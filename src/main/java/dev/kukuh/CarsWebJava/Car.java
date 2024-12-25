package dev.kukuh.CarsWebJava;

public class Car {
    private String name;
    private double length;
    private double weight;
    private double velocity;
    private String color;

    public Car(String name, double length, double weight, double velocity, String color) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.velocity = velocity;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public double getVelocity() {
        return velocity;
    }

    public String getColor() {
        return color;
    }
}
