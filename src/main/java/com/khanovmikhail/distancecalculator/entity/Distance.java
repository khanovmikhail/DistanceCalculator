package com.khanovmikhail.distancecalculator.entity;

import jakarta.persistence.*;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@Entity
@Table(name = "distance")
@XmlType(propOrder = {"fromCity", "toCity", "distance"}, name = "distance")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Distance {

    @Id
    @Column(name = "distance_id", nullable = false, columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "from_city", nullable = false, columnDefinition = "BIGINT")
    @XmlElement(name = "from_city")
    private City fromCity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "to_city", nullable = false, columnDefinition = "BIGINT")
    @XmlElement(name = "to_city")
    private City toCity;

    @Column(name = "distance", columnDefinition = "DOUBLE")
    @XmlElement(name = "value")
    private double distance;

    public Distance() {
    }

    public Distance(int id, City fromCity, City toCity, double distance) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", fromCity=" + fromCity +
                ", toCity=" + toCity +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;
        Distance distance1 = (Distance) o;
        return Double.compare(distance1.getDistance(), getDistance()) == 0 && getFromCity().equals(distance1.getFromCity()) && getToCity().equals(distance1.getToCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFromCity(), getToCity(), getDistance());
    }
}
