package ru.mirea.lab4.task2;

public class AtelierTest {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.M, 1500, "белый"),
                new Pants(Size.L, 3200, "синий"),
                new Skirt(Size.XS, 2700, "красный"),
                new Tie(Size.S, 990, "черный"),
                new TShirt(Size.XXS, 800, "желтый")
        };

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        System.out.println();
        atelier.dressMan(clothes);
    }
}
