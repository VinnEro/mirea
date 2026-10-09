package ru.mirea.lab4.task2;

public class Atelier {
    // "Подумайте, какой тип будет у массива": общий тип у всех вещей - Clothes,
    // поэтому принимаем Clothes[]. Массив MenClothing[] не подошёл бы - в него нельзя положить юбку.
    // А дальше через instanceof отбираем только то, что умеет "одевать" женщину/мужчину.
    public void dressWomen(Clothes[] clothes) {
        System.out.println("--- Женская одежда ---");
        for (Clothes item : clothes) {
            // Pattern matching для instanceof (Java 16+): проверка и приведение типа в одной строке,
            // не нужно отдельно писать ((WomenClothing) item).dressWomen().
            if (item instanceof WomenClothing women) women.dressWomen();
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("--- Мужская одежда ---");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing men) men.dressMan();
        }
    }
}
