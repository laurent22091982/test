package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gautier Olivier
 *
 */

public class CityServices {

    public static City findOneCity(int id) {
        City city;
        EntityFinder<City> ef = new EntityFinderImpl<>();
        city = ef.findOne(new City(), id);

        return city;
    }

    public static List<City> findAllCities() {
        List<City> cityList;
        EntityFinder<City> ef = new EntityFinderImpl<>();
        cityList = ef.findByNamedQuery("City.findAll", new City(), null);

        return cityList;
    }

    public static ArrayList<City> findCitiesByZipCode(String zipCode) {
        List<City> cityList;
        EntityFinder<City> ef = new EntityFinderImpl<>();
        Map<String, String> params = new HashMap<>();
        params.put("zipCode", zipCode + '%');
        cityList = ef.findByNamedQuery("City.findZipCode", new City(), params);
        return new ArrayList<>(cityList);
    }
}
