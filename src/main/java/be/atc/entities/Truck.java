package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the trucks database table.
 * 
 */
@Entity
@Table(name="trucks")
@NamedQuery(name="Truck.findAll", query="SELECT t FROM Truck t")
public class Truck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	@NotNull
	private float price;

	//bi-directional many-to-one association to Packaging
	@OneToMany(mappedBy="truck")
	private List<Packaging> packagings;

	//bi-directional many-to-one association to Carrier
	@ManyToOne
	@JoinColumn(name="id_carrier")
	private Carrier carrier;

	//bi-directional many-to-one association to TruckModel
	@ManyToOne
	@JoinColumn(name="id_truck_model")
	private TruckModel truckModel;

	public Truck() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Packaging> getPackagings() {
		return this.packagings;
	}

	public void setPackagings(List<Packaging> packagings) {
		this.packagings = packagings;
	}

	public Packaging addPackaging(Packaging packaging) {
		getPackagings().add(packaging);
		packaging.setTruck(this);

		return packaging;
	}

	public Packaging removePackaging(Packaging packaging) {
		getPackagings().remove(packaging);
		packaging.setTruck(null);

		return packaging;
	}

	public Carrier getCarrier() {
		return this.carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public TruckModel getTruckModel() {
		return this.truckModel;
	}

	public void setTruckModel(TruckModel truckModel) {
		this.truckModel = truckModel;
	}

}