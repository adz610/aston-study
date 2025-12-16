package org.example;

public class ComputerMouse {
    private String name;
    private String productionDate;
    private String producer;
    private String countryOfOrigin;
    private double price;
    private boolean booked;

    public ComputerMouse(String name, String productionDate, String producer, String countryOfOrigin, double price, boolean booked) {
        this.name = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.booked = booked;
    }

    public void getInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + producer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + "$");
        System.out.println("Забронировано: " + booked);
    }
}
