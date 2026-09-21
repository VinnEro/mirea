package ru.mirea.lab2;

public class Task_1 {
    public static void main(String[] args) {
        Author author = new Author("Vladislav", "ivVinnEro@exapmle.com", 'M');
        System.out.println(author.toString());
        author.setEmail("vinn.new@somewhere.com");
        System.out.println("Обновленный email: " + author.getEmail());
    }
}

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public char getGender() { return gender; }

    @Override
    public String toString() {
        return "Author{name='" + name + "', email='" + email + "', gender=" + gender + "}";
    }
}