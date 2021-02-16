package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the truck_models database table.
 * 
 */
@Entity
@Table(name="trucks_models")
@NamedQuery(name="TruckModel.findAll", query="SELECT t FROM TruckModel t")
public class TruckModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	private boolean active;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	@NotNull
	@Column(name="max_volume")
	private float maxVolume;

	@NotNull
	@Column(name="max_weight")
	private float maxWeight;

	//bi-directional many-to-one association to Truck
	@OneToMany(mappedBy="truckModel")
	private List<Truck> trucks;

	public TruckModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getMaxVolume() {
		return this.maxVolume;
	}

	public void setMaxVolume(float maxVolume) {
		this.maxVolume = maxVolume;
	}

	public float getMaxWeight() {
		return this.maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public List<Truck> getTrucks() {
		return this.trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

	public Truck addTruck(Truck truck) {
		getTrucks().add(truck);
		truck.setTruckModel(this);

		return truck;
	}

	public Truck removeTruck(Truck truck) {
		getTrucks().remove(truck);
		truck.setTruckModel(null);

		return truck;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TruckModel)) {
			return false;
		}
		TruckModel other = (TruckModel) obj;
		return (this.id != 0 || other.id == 0) && (this.id == 0 || this.id == other.id);
	}

	@Override
	public int hashCode()  {
		return Objects.hash(id, label, maxWeight, maxVolume);
	}

	@Override
	public String toString() {
		return String.valueOf(getId());
	}
}