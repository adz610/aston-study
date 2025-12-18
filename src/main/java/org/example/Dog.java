package org.example;

public class Dog extends Animal {
    private static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        if (0 <= distance && distance <= 500)
            System.out.println(name + " пробежал " + distance + " м.");
        else
            System.out.println("Ошибка: " + name + " может пробежать от 0 до 500 метров");
    }

    public void swim(int distance) {
        if (0 <= distance && distance <= 10)
            System.out.println(name + " проплыл " + distance + " м.");
        else
            System.out.println("Ошибка: " + name + " может проплыть от 0 до 10 метров");
    }
}
