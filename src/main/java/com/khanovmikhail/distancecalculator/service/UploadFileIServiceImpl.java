package com.khanovmikhail.distancecalculator.service;

import com.khanovmikhail.distancecalculator.dao.CityDAO;
import com.khanovmikhail.distancecalculator.dao.DistanceDAO;
import com.khanovmikhail.distancecalculator.entity.City;
import com.khanovmikhail.distancecalculator.entity.Distance;
import com.khanovmikhail.distancecalculator.entity.xml.XmlEntity;
import com.khanovmikhail.distancecalculator.entity.xml.XmlDistanceEntity;
import com.khanovmikhail.distancecalculator.exception.BadRequestException;
import com.khanovmikhail.distancecalculator.exception.NoCityInDBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadFileIServiceImpl implements UploadFileService {
    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private DistanceDAO distanceDAO;

    @Override
    public void uploadXml(MultipartFile multipartFile) {
        try(BufferedInputStream inputStream = new BufferedInputStream(multipartFile.getInputStream())){

            JAXBContext jaxbContext = JAXBContext.newInstance(XmlEntity.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            XmlEntity xmlEntity = (XmlEntity) unmarshaller.unmarshal(inputStream);

            List<City> cityList = xmlEntity.getCityList();
            if(cityList != null){
                saveCities(cityList);
            }

            List<XmlDistanceEntity> xmlDistanceEntityList = xmlEntity.getXmlDistanceEntityList();
            if(xmlDistanceEntityList != null){
                saveDistances(xmlDistanceEntityList);
            }

        } catch (Exception e){
            throw new BadRequestException("problem with uploaded file " + e.getLocalizedMessage());
        }
    }

    private void removeCitiesAlreadyExistInDB(List<City> cityList){
        List<String> citiesInDBNames = cityDAO.getAllCities().stream().map(City::getName).toList();
        cityList.removeIf(city -> citiesInDBNames.contains(city.getName()));
    }

    private void removeDistancesAlreadyExistInDB(List<Distance> distanceList){
        List<Distance> distancesInDB = distanceDAO.getAllDistanceList();
        distanceList.removeIf(distancesInDB::contains);
    }

    private void saveCities(List<City> cityList){
        removeCitiesAlreadyExistInDB(cityList);
        if(cityList.size() != 0 ){
            cityDAO.saveAllCities(cityList);
        }
    }

    private void saveDistances(List<XmlDistanceEntity> xmlDistanceEntityList){

            List<Distance> distances = new ArrayList<>();
            List<City> cities = cityDAO.getAllCities();

            for (int i = 0; i < xmlDistanceEntityList.size(); i++) {
                XmlDistanceEntity xmlDistance = xmlDistanceEntityList.get(i);

                String fromCity = xmlDistance.getFromCity();
                String toCity = xmlDistance.getToCity();

                City cityFrom = getCityByName(cities, fromCity);
                City cityTo = getCityByName(cities, toCity);

                Distance distance = new Distance();
                distance.setFromCity(cityFrom);
                distance.setToCity(cityTo);
                distance.setDistance(xmlDistance.getValue());

                distances.add(distance);
            }

        removeDistancesAlreadyExistInDB(distances);

        if(distances.size() != 0) {
            distanceDAO.saveAllDistances(distances);
        }
    }

    private City getCityByName(List<City> cities, String name){
        for (int i = 0; i < cities.size(); i++) {
            if(cities.get(i).getName().equals(name)){
                return cities.get(i);
            }
        }
        throw new NoCityInDBException("No city in Database");
    }
}
