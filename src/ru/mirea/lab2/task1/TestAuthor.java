package ru.mirea.lab2.task1;

public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Ivaschenko Vladislav", "vinnero@somewhere.com", 'M');
        System.out.println(author.toString());
        author.setEmail("buhepo@example.com");
        System.out.println("Обновленный email: " + author.getEmail());
    }
}