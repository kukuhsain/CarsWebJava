package dev.kukuh.CarsWebJava;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlElement
    private long id;
    @XmlElement
    private double length;
    @XmlElement
    private double weight;
    @XmlElement
    private double velocity;
    @XmlElement
    private String color;

    public Car() {
    }

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
