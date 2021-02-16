package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import be.atc.entities.Truck;

import java.util.List;

/**
 * @author Gautier Olivier
 *
 */

public class TruckServices {

    public static List<Truck> findAllTrucks() {
        List<Truck> allTrucksList;
        EntityFinder<Truck> ef = new EntityFinderImpl<>();
        allTrucksList = ef.findByNamedQuery("Truck.findAll", new Truck(), null);

        return allTrucksList;
    }

}
