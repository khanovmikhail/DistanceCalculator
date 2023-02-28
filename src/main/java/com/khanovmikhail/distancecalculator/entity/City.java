package com.khanovmikhail.distancecalculator.entity;

import jakarta.persistence.*;

import javax.xml.bind.annotation.*;

@Entity
@Table(name = "city")
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @Id
    @Column(name = "city_id", nullable = false, columnDefinition = "BIGINT", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(50)")
    @XmlElement(name = "name")
    private String name;

    @Column(name = "latitude", nullable = false, columnDefinition = "DOUBLE")
    @XmlElement(name = "latitude")
    private Double latitude;

    @Column(name = "longitude", nullable = false, columnDefinition = "DOUBLE")
    @XmlElement(name = "longitude")
    private Double longitude;

    public City(){}

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
