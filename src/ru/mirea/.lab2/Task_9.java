package ru.mirea.lab2;
import java.util.Scanner;
import java.util.Random;

public class Task_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество игроков: ");
        int n = sc.nextInt();
        IO.print("Input card count: ");
        int cardCount = sc.nextInt();

        if (n <= 0 || n > 10) {
            System.out.println("Некорректное число игроков (от 1 до 10).");
            return;
        }

        String[] suits = {"Пики", "Крести", "Бубны", "Черви"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};
        String[] deck = new String[52];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " " + suit;
            }
        }

        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = rand.nextInt(deck.length);
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        index = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Игрок " + (i + 1) + ":");
            for (int j = 0; j < cardCount; j++) {
                System.out.println(deck[index++]);
            }
            System.out.println();
        }
    }
}