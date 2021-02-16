package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import be.atc.entities.TruckModel;

import java.util.List;

/**
 * @author Gautier Olivier
 *
 */

public class TruckModelServices {

    public static List<TruckModel> findAllTruckModels() {
        List<TruckModel> truckModelsList;
        EntityFinder<TruckModel> ef = new EntityFinderImpl<>();
        truckModelsList = ef.findByNamedQuery("TruckModel.findAll", new TruckModel(), null);

        return truckModelsList;
    }

}
