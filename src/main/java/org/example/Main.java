package org.example;

public class Main {
    public static void main(String[] args) {
        ComputerMouse[] mouses = {
            new ComputerMouse("Logitech G Pro", "17.08.2023", "Logitech", "USA", 109.99, false),
            new ComputerMouse("LAMZU Atlantis", "04.06.2024", "LAMZU", "China", 99.99, false),
            new ComputerMouse("Hitscan Hyperlight", "11.07.2025", "Hitscan", "China", 89.99, true),
            new ComputerMouse("Finalmouse ULX Frostlord", "27.11.2025", "Finalmouse", "Vietnam", 175, false),
            new ComputerMouse("Razer Deathadder v2", "14.01.2020", "Razer", "Singapore", 59.99, true)
        };

        System.out.println("Список товаров:");
        for (int i = 0; i < mouses.length; i++) {
            System.out.println("Мышь №" + (i + 1) + ":");
            mouses[i].getInfo();
            System.out.println();
        }

        Park park = new Park("Knott's Berry Farm");
        Park.Attraction[] attractions = {
            park.new Attraction("Xcelerator", "10:00 - 22:00", 59.99),
            park.new Attraction("GhostRider", "11:00 - 23:00", 65.99),
            park.new Attraction("Supreme Scream", "9:00 - 21:30", 70),
            park.new Attraction("Silver Bullet", "8:30 - 22:00", 54.99),
            park.new Attraction("Jaguar!", "9:00 - 21:00", 49.99)
        };

        System.out.println("Аттракционы парка \"" + park.getName() + "\":");
        for (Park.Attraction attraction : attractions) {
            attraction.getInfo();
            System.out.println("1");
        }
    }
}