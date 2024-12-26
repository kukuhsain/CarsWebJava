package dev.kukuh.CarsWebJava;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlElement
    public long id;
    @XmlElement
    public double length;
    @XmlElement
    public double weight;
    @XmlElement
    public double velocity;
    @XmlElement
    public String color;

    public Car() {
    }

    public Car(long id, double length, double weight, double velocity, String color) {
        this.id = id;
        this.length = length;
        this.weight = weight;
        this.velocity = velocity;
        this.color = color;
    }

    // @XmlElement
    public long getId() {
        return id;
    }

    // @XmlElement
    public double getLength() {
        return length;
    }

    // @XmlElement
    public double getWeight() {
        return weight;
    }

    // @XmlElement
    public double getVelocity() {
        return velocity;
    }

    // @XmlElement
    public String getColor() {
        return color;
    }
}
