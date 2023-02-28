package com.khanovmikhail.distancecalculator.dao;

import com.khanovmikhail.distancecalculator.entity.City;
import com.khanovmikhail.distancecalculator.entity.Distance;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DistanceDAOImpl implements DistanceDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Distance> getAllDistanceList() {
        Session session = entityManager.unwrap(Session.class);
        Query<Distance> distanceQuery = session.createQuery("from Distance", Distance.class);
        List<Distance> allDistance = distanceQuery.getResultList();
        return allDistance;
    }

    @Override
    public double findMatrixDistanceByCitiesNames(String cityFrom, String cityTo) {
        Session session = entityManager.unwrap(Session.class);
        Query<Double> distanceQuery = session.createQuery("SELECT distance FROM Distance " +
                "WHERE (fromCity.name = :cityFrom AND toCity.name= :cityTo) " +
                "OR (fromCity.name = :cityTo AND toCity.name= :cityFrom)", Double.class);
        distanceQuery.setParameter("cityFrom", cityFrom);
        distanceQuery.setParameter("cityTo",cityTo);
        return distanceQuery.getSingleResult();
    }

    @Override
    public void saveAllDistances(List<Distance> distanceList) {
        int BATCH_SIZE = 5;
        for (int i = 0; i < distanceList.size(); i++) {
            entityManager.persist(distanceList.get(i));

            if((i + 1) % BATCH_SIZE == 0){
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
