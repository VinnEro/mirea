package ru.mirea.lab4_1.task5;

public class Reader {
    private String fullName;
    private int ticketNumber;
    private String faculty;
    private String birthDate;
    private String phone;

    public Reader(String fullName, int ticketNumber, String faculty, String birthDate, String phone) {
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public String getFullName() { return fullName; }
    public int getTicketNumber() { return ticketNumber; }

    // ----- takeBook: три перегрузки -----
    // Перегрузка работает, потому что списки параметров разные: int, String..., Book...
    // Компилятор выбирает метод по типу аргументов, поэтому takeBook(3) и takeBook("Словарь") не путаются.

    public void takeBook(int count) {
        System.out.println(fullName + " взял " + count + " " + bookWord(count));
    }

    public void takeBook(String... titles) {
        // String.join сам расставит запятые между элементами - не нужно отдельно следить за последней запятой.
        System.out.println(fullName + " взял книги: " + String.join(", ", titles));
    }

    public void takeBook(Book... books) {
        System.out.println(fullName + " взял книги: " + titlesOf(books));
    }

    // ----- returnBook: те же три варианта -----

    public void returnBook(int count) {
        System.out.println(fullName + " вернул " + count + " " + bookWord(count));
    }

    public void returnBook(String... titles) {
        System.out.println(fullName + " вернул книги: " + String.join(", ", titles));
    }

    public void returnBook(Book... books) {
        System.out.println(fullName + " вернул книги: " + titlesOf(books));
    }

    // Вынесено в отдельный метод, потому что нужно и в takeBook, и в returnBook -
    // так логика сборки списка названий не дублируется.
    private String titlesOf(Book[] books) {
        String[] titles = new String[books.length];
        for (int i = 0; i < books.length; i++) titles[i] = books[i].getTitle();
        return String.join(", ", titles);
    }

    // "1 книгу", "3 книги", "5 книг" - русское склонение зависит от последних цифр числа.
    // 11-14 - исключение: "11 книг", хотя число оканчивается на 1.
    private String bookWord(int count) {
        int lastTwo = count % 100;
        int last = count % 10;
        if (lastTwo >= 11 && lastTwo <= 14) return "книг";
        if (last == 1) return "книгу";
        if (last >= 2 && last <= 4) return "книги";
        return "книг";
    }

    @Override
    public String toString() {
        return String.format("Читатель №%d: %s, факультет %s, д.р. %s, тел. %s", ticketNumber, fullName, faculty, birthDate, phone);
    }
}
