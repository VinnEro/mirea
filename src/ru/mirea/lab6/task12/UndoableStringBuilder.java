package ru.mirea.lab6.task12;
import java.util.ArrayDeque;
import java.util.Deque;

// Почему не "extends StringBuilder"? Класс StringBuilder объявлен как final - наследоваться от него нельзя.
// Поэтому используем делегирование: храним настоящий StringBuilder внутри и перенаправляем вызовы ему,
// добавляя по дороге запись в историю.
public class UndoableStringBuilder {
    private final StringBuilder builder = new StringBuilder();
    // История команд - это стек: отменяется всегда ПОСЛЕДНЯЯ операция (LIFO).
    // ArrayDeque вместо устаревшего класса Stack: Stack синхронизирован (медленнее) и наследует Vector,
    // из-за чего у него есть "лишние" методы вроде get(i), ломающие идею стека.
    private final Deque<Command> history = new ArrayDeque<>();

    public UndoableStringBuilder() {}
    public UndoableStringBuilder(String initial) { builder.append(initial); }   // начальное значение отменять нечего

    // Общий путь для всех изменяющих операций: выполнить команду и запомнить её.
    private UndoableStringBuilder run(Command command) {
        command.execute();
        history.push(command);
        return this;    // возвращаем this, чтобы работали цепочки вызовов, как у обычного StringBuilder
    }

    // ---------- изменяющие операции (записываются в историю) ----------

    // Принимаем Object: благодаря автоупаковке сюда подходят и строки, и числа, и символы,
    // а String.valueOf превратит любой из них в текст так же, как это делает StringBuilder.
    public UndoableStringBuilder append(Object value) {
        String text = String.valueOf(value);
        return run(new Command() {
            @Override public void execute() { builder.append(text); }
            // Чтобы отменить append, достаточно удалить столько символов с конца, сколько добавили.
            @Override public void undo() { builder.setLength(builder.length() - text.length()); }
        });
    }

    public UndoableStringBuilder insert(int offset, Object value) {
        String text = String.valueOf(value);
        return run(new Command() {
            @Override public void execute() { builder.insert(offset, text); }
            @Override public void undo() { builder.delete(offset, offset + text.length()); }
        });
    }

    public UndoableStringBuilder delete(int start, int end) {
        // Удалённый текст нужно запомнить ДО удаления - иначе вернуть его будет неоткуда.
        // Math.min повторяет поведение StringBuilder.delete: end больше длины - удаляем до конца.
        String removed = builder.substring(start, Math.min(end, builder.length()));
        return run(new Command() {
            @Override public void execute() { builder.delete(start, end); }
            @Override public void undo() { builder.insert(start, removed); }
        });
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        return delete(index, index + 1);
    }

    public UndoableStringBuilder replace(int start, int end, String str) {
        String old = builder.substring(start, Math.min(end, builder.length()));
        return run(new Command() {
            @Override public void execute() { builder.replace(start, end, str); }
            // После замены на месте старого текста стоит str - его и заменяем обратно на old.
            @Override public void undo() { builder.replace(start, start + str.length(), old); }
        });
    }

    public UndoableStringBuilder reverse() {
        return run(new Command() {
            @Override public void execute() { builder.reverse(); }
            // Разворот - сам себе обратная операция, развернуть ещё раз = отменить.
            @Override public void undo() { builder.reverse(); }
        });
    }

    public UndoableStringBuilder setCharAt(int index, char c) {
        char old = builder.charAt(index);
        return run(new Command() {
            @Override public void execute() { builder.setCharAt(index, c); }
            @Override public void undo() { builder.setCharAt(index, old); }
        });
    }

    // ---------- undo ----------

    // Возвращаем boolean, а не бросаем исключение: "нечего отменять" - нормальная ситуация, а не ошибка.
    public boolean undo() {
        if (history.isEmpty()) return false;
        history.pop().undo();
        return true;
    }

    public int getHistorySize() { return history.size(); }

    // ---------- не изменяющие методы - просто делегируем ----------

    public int length() { return builder.length(); }
    public char charAt(int index) { return builder.charAt(index); }
    public int indexOf(String str) { return builder.indexOf(str); }
    public String substring(int start, int end) { return builder.substring(start, end); }

    @Override public String toString() { return builder.toString(); }
}
