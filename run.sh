#!/usr/bin/env bash
# Запуск практических работ из терминала.
#
#   bash run.sh                          - собрать и прогнать ВСЕ программы lab1-lab7 с заготовленным вводом
#   bash run.sh lab4_1                   - прогнать все программы одной лабы
#   bash run.sh lab4.task3.OnlineShop    - запустить одну программу ИНТЕРАКТИВНО (ввод с клавиатуры)
#   bash run.sh lab1.task_3 a b c        - то же, с аргументами командной строки
#   bash run.sh --list                   - показать список всех программ
#
# Запускать из папки проекта (code/pw1). Нужен JDK 25+ (lab1 использует IO.println).

cd "$(dirname "$0")" || exit 1
OUT="out/terminal"
PKG="ru.mirea"

# Каждая строка: класс | аргументы | ввод (\n = Enter). Пустой ввод - программа ничего не спрашивает.
PROGRAMS='
lab1.task_1||
lab1.task_2||5\n3 -1 7 0 2\n
lab1.task_3|Привет мир 42|
lab1.task_4||
lab1.task_5||
lab2.task1.TestAuthor||
lab2.task2.TestBall||
lab2.task3.Tester||
lab2.task4.ShopTest||2\nAsus ROG\nLenovo\nLenovo\n
lab2.task5.DogKennel||
lab2.task6.CircleTest||
lab2.task7.BookTest||
lab2.task8.StringArrayReverse||
lab2.task9.Poker||3\n
lab2.task10.HowMany||Java это просто\n
lab3.task1.RandomArraySort||
lab3.task2.Tester||
lab3.task3.IncreasingSequence||
lab3.task4.EvenElements||abc\n-3\n7\n
lab3.task5.EvenElementsRandom||x\n0\n6\n
lab3.wrappers.task1.DoubleWrapper||
lab3.wrappers.task2.WrapperMethodsTable||
lab3.format.task1.ConverterTest||1500\nUSD\nRUB\n
lab3.format.task2.OnlineShop||2\n3\nEUR\n
lab3.format.task3.ReportTest||
lab4.task1.SeasonTest||
lab4.task2.AtelierTest||
lab4.task3.OnlineShop||vinnero\nwrong\nvinnero\nqwerty\n1\n3\n1\n1\n3\n2\n2\n4\n5\n0\n
lab4.task4.ComputerTest||
lab4_1.task1.ShapeTest||
lab4_1.task2.PhoneTest||
lab4_1.task3.PersonTest||
lab4_1.task4.MatrixTest||
lab4_1.task5.ReaderTest||
lab4_1.task6.EmployerTest||
lab4_1.task7.LearnerTest||
lab4_1.task8.ShapeTest||
lab4_1.task9.FurnitureTest||
lab4_1.task10.VehicleTest||
lab6.task1.MovableTest||
lab6.task2.MovableRectangleTest||
lab6.task3.NameableTest||
lab6.task4.PriceableTest||
lab6.task5.MovableTest||
lab6.task6.PrintableTest||
lab6.task10.ShopTest||2\nlenovo\nThinkPad\ni5\n4\n2,4\n16\n14\n80000\nApple\nMacBook\nM3\n8\n4\n8\n13.6\n120000\nmacbook\napple\nThinkPad\n
lab6.task11.TemperatureTest||36,6\n
lab6.task12.UndoTest||
lab6.task13.ObserverTest||
lab7.task1.MovableRectangleTest||
lab7.task4.MathFuncTest||
lab7.task5.ProcessStringsTest||Hello World Java\n
lab7.task7.PrintableTest||
'

GREEN='\033[1;32m'; RED='\033[1;31m'; CYAN='\033[1;36m'; GRAY='\033[0;90m'; NC='\033[0m'

if [ "$1" = "--list" ]; then
    echo "$PROGRAMS" | grep -v '^$' | cut -d'|' -f1
    exit 0
fi

# ---------- 1. Компиляция ----------
echo -e "${CYAN}Компиляция...${NC}"
mkdir -p "$OUT"
find src -name '*.java' -not -path '*/.*/*' > "$OUT/sources.txt"   # скрытые папки (.lab2) пропускаем
if ! javac -encoding UTF-8 -d "$OUT" @"$OUT/sources.txt"; then
    echo -e "${RED}Ошибка компиляции.${NC} Проверьте версию: java -version (нужен JDK 25+)"
    exit 1
fi
echo -e "${GREEN}OK: $(wc -l < "$OUT/sources.txt") файлов скомпилировано${NC}"

JAVA="java -Dstdout.encoding=UTF-8 -cp $OUT"

# ---------- 2. Одна программа интерактивно ----------
# Если аргумент похож на имя класса (есть точка после labN) - запускаем его с клавиатурным вводом.
if [[ "$1" == lab*.* ]]; then
    class="$1"; shift
    echo -e "${CYAN}===== ${PKG}.${class} =====${NC}"
    $JAVA "${PKG}.${class}" "$@"
    exit $?
fi

# ---------- 3. Прогон всех (или одной лабы) с заготовленным вводом ----------
filter="${1:-}"
passed=0; failed=0; failed_list=""

while IFS='|' read -r class args input; do
    [ -z "$class" ] && continue
    # bash run.sh lab4 не должен захватывать lab4_1, поэтому сравниваем с "lab4."
    if [ -n "$filter" ] && [[ "$class" != "$filter".* ]]; then continue; fi

    echo
    echo -e "${CYAN}======================== ${class} ========================${NC}"
    [ -n "$args" ]  && echo -e "${GRAY}Аргументы: ${args}${NC}"
    [ -n "$input" ] && echo -e "${GRAY}Ввод: ${input//\\n/ ⏎ }${NC}"

    # shellcheck disable=SC2086
    if printf "$input" | $JAVA "${PKG}.${class}" $args; then
        passed=$((passed + 1))
    else
        failed=$((failed + 1)); failed_list="$failed_list $class"
    fi
done <<< "$PROGRAMS"

echo
echo -e "${CYAN}========================= ИТОГ =========================${NC}"
echo -e "${GREEN}Успешно: $passed${NC}"
if [ "$failed" -gt 0 ]; then
    echo -e "${RED}С ошибкой: $failed ->$failed_list${NC}"
    exit 1
fi
