package com.khanovmikhail.distancecalculator.dao;

import com.khanovmikhail.distancecalculator.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CityDAOImpl implements CityDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<City> getAllCities() {
        Session session = entityManager.unwrap(Session.class);
        Query<City> cityQuery = session.createQuery("from City", City.class);
        List<City> allCities = cityQuery.getResultList();
        return allCities;
    }

    @Override
    public City getCityByName(String name){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from City where name=:name", City.class);
        query.setParameter("name", name);
        return (City) query.getSingleResult();
    }

    @Override
    public void saveAllCities(List<City> cityList) {
        int BATCH_SIZE = 5;
        for (int i = 0; i < cityList.size(); i++) {
            entityManager.persist(cityList.get(i));

            if((i + 1) % BATCH_SIZE == 0){
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
