package org.example;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Animal bobik = new Dog("Бобик");
        Cat barsik = new Cat("Барсик");

        bobik.run(150);
        bobik.swim(15);

        barsik.run(50);
        barsik.swim(5);

        System.out.println("Количество животных: " + Animal.getCount());
        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество котов: " + Cat.getCount());

        int food = 20;
        food = barsik.eat(10, food);
        System.out.println(barsik.getName() + " сытый: " + barsik.isFull());

        Cat[] cats = {
            new Cat("Марсик"),
            new Cat("Борик"),
            new Cat("Рыжик"),
            new Cat("Мурзик"),
            new Cat("Кузя")
        };

        food = Cat.giveFood(35, food);

        for (Cat cat : cats) {
            food = cat.eat(10, food);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сытый: " + cat.isFull());
        }

        Circle circle = new Circle(0xFFFFFF, 0x000000, 5);
        circle.getInfo();

        Rectangle rectangle = new Rectangle(0xFF0000, 0x00FF00, 2, 4);
        rectangle.getInfo();

        Triangle triangle = new Triangle(0xA6FFA3, 0x034F00, 3, 2, 2);
        triangle.getInfo();
    }
}