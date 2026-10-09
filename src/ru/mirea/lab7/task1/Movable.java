package ru.mirea.lab7.task1;

// Пункты 1-3 седьмой работы - это одна программа (диаграмма -> классы -> конструкторы, toString, SpeedTest),
// поэтому они собраны в одном пакете. По смыслу это продолжение lab6.task2, но методичка просит
// построить классы заново по своей диаграмме, так что здесь они самостоятельные и не зависят от lab6.
//
// UML-диаграмма (draw.io), по которой написан код:
//
//            <<interface>> Movable
//            + moveUp(): void
//            + moveDown(): void
//            + moveLeft(): void
//            + moveRight(): void
//                 ^            ^
//       implements|            |implements
//   MovablePoint  |            |  MovableRectangle
//   ~ x, y: int   | 2       1  |  - topLeft: MovablePoint
//   ~ xSpeed: int <>-----------   - bottomRight: MovablePoint
//   ~ ySpeed: int                 + MovableRectangle(x1,y1,x2,y2,xSpeed,ySpeed)
//   + MovablePoint(x,y,xSpeed,ySpeed)  + SpeedTest(): boolean
//   + toString(): String          + toString(): String
public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
