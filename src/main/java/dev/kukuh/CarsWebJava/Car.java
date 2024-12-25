package dev.kukuh.CarsWebJava;

public class Car {
    private long id;
    private double length;
    private double weight;
    private double velocity;
    private String color;

    public Car(long id, double length, double weight, double velocity, String color) {
        this.id = id;
        this.length = length;
        this.weight = weight;
        this.velocity = velocity;
        this.color = color;
    }

    public long getId() {
        return id;
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
