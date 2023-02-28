package com.khanovmikhail.distancecalculator.entity.xml;

import com.khanovmikhail.distancecalculator.entity.City;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlEntity {

    @XmlElement(name = "city", nillable = true)
    private List<City> cityList = null;

    @XmlElement(name = "distance", nillable = true)
    private List<XmlDistanceEntity> xmlDistanceEntityList = null;

    public XmlEntity() {
    }

    public XmlEntity(List<City> cityList, List<XmlDistanceEntity> xmlDistanceEntityList) {
        this.cityList = cityList;
        this.xmlDistanceEntityList = xmlDistanceEntityList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<XmlDistanceEntity> getXmlDistanceEntityList() {
        return xmlDistanceEntityList;
    }

    public void setXmlDistanceEntityList(List<XmlDistanceEntity> xmlDistanceEntityList) {
        this.xmlDistanceEntityList = xmlDistanceEntityList;
    }

    @Override
    public String toString() {
        return "MySecondXmlEntity{" +
                "cityList=" + cityList +
                ", xmlDistanceEntityList=" + xmlDistanceEntityList +
                '}';
    }
}
