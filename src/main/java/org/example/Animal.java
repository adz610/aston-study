package org.example;

public abstract class Animal {
    private static int count = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        System.out.println("Животное " + name + " пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное " + name + " проплыло " + distance + " м.");
    }

    public String getName() {
        return name;
    }
}
