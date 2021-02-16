package be.atc.beans;

import be.atc.entities.Truck;
import be.atc.entities.TruckModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static be.atc.services.TruckModelServices.*;
import static be.atc.services.TruckServices.*;

@Named
@RequestScoped
public class TrucksBean implements Serializable {
    private static final long serialVersionUID = 1L;

    List<Truck> trucksList = findAllTrucks();
    List<TruckModel> modelsList = findAllTruckModels();

    public void addTruck() {

    }

    public List<Truck> getTrucksList() {
        return trucksList;
    }

    public void setTrucksList(List<Truck> trucksList) {
        this.trucksList = trucksList;
    }

    public List<TruckModel> getModelsList() {
        return modelsList;
    }

    public void setModelsList(List<TruckModel> modelsList) {
        this.modelsList = modelsList;
    }

}
