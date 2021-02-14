package be.atc.utils;

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

public class CityUtils {

    public static City findOneCity(int id) {
        City city;
        EntityFinder<City> ef = new EntityFinderImpl<City>();
        city = ef.findOne(new City(), id);

        return city;
    }

    public static List<City> findAllCity() {
        List<City> cityList;
        EntityFinder<City> ef = new EntityFinderImpl<City>();
        cityList = ef.findByNamedQuery("City.findAll", new City(), null);

        return cityList;
    }

    public static ArrayList<City> findPostcodeCity(String zipCode) {
        List<City> cityList;
        ArrayList<City> cityArrayList = new ArrayList<>();
        EntityFinder<City> ef = new EntityFinderImpl<City>();
        Map<String, String> params = new HashMap<>();
        params.put("zipCode", zipCode + '%');
        cityList = ef.findByNamedQuery("City.findZipCode", new City(), params);
        cityArrayList.addAll(cityList);
        return cityArrayList;
    }
}
