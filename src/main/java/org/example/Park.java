package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractions = new ArrayList<>();

    public Park(String name) {
        parkName = name;
    }

    public void getInfo() {
        System.out.println("Аттракционы парка \"" + parkName + "\":");
        for (Attraction attraction : attractions) {
            attraction.getInfo();
            System.out.println();
        }
    }

    public void newAttraction(String name, String openingHours, double price) {
        Attraction attraction = new Attraction(name, openingHours, price);
        attractions.add(attraction);
    }

    public class Attraction {
        private String attractionName;
        private String openingHours;
        private double price;

        public Attraction(String name, String openingHours, double price) {
            attractionName = name;
            this.openingHours = openingHours;
            this.price = price;
        }

        public void getInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + openingHours);
            System.out.println("Стоимость билета: " + price + "$");
        }
    }
}
