package org.example;

public class Park {
    private String parkName;

    public Park(String name) {
        parkName = name;
    }

    public String getName() {
        return parkName;
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
