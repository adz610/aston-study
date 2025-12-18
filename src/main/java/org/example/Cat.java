package org.example;

public class Cat extends Animal {
    private static int count = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static int giveFood(int foodGiveAmount, int foodAmount) {
        if (foodGiveAmount > 0) {
            foodAmount += foodGiveAmount;
            System.out.println("Вы насыпали " + foodGiveAmount + " еды в миску");
            System.out.println("В миске теперь " + foodAmount + " еды");
        } else
            System.out.println("Вы должны насыпать в миску хотя бы 1 еду");
        return foodAmount;
    }

    public void run(int distance) {
        if (0 <= distance && distance <= 200)
            System.out.println("Кот " + name + " пробежал " + distance + " м.");
        else
            System.out.println("Ошибка: " + name + " может пробежать от 0 до 200 метров");
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public int eat(int eatAmount, int foodAmount) {
        if (eatAmount > 0) {
            if (foodAmount < eatAmount) {
                System.out.println("В миске кота " + name + " недостаточно еды");
                return foodAmount;
            }
            foodAmount -= eatAmount;
            System.out.println(name + " съел " + eatAmount + " еды");
            System.out.println("В миске осталось " + foodAmount + " еды");
            isFull = true;
        } else
            System.out.println("Ошибка: " + name + " не может съесть меньше 1 еды");
        return foodAmount;
    }

    public boolean isFull() {
        return isFull;
    }
}
