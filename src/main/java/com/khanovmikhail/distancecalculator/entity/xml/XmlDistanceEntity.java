package com.khanovmikhail.distancecalculator.entity.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "distance")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDistanceEntity {

    @XmlElement(name = "from_city")
    private String fromCity;

    @XmlElement(name = "to_city")
    private String toCity;

    @XmlElement(name = "value")
    private double value;

    public XmlDistanceEntity() {
    }

    public XmlDistanceEntity(String fromCity, String toCity, double value) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.value = value;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "XmlDistanceEntity{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", value=" + value +
                '}';
    }
}
