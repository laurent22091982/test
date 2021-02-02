package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * The persistent class for the packagings database table.
 * 
 */
@Entity
@Table(name="packagings")
@NamedQuery(name="Packaging.findAll", query="SELECT p FROM Packaging p")
public class Packaging implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name="packaging_type")
	private String packagingType;

	@NotNull
	private String status;

	@NotNull
	private float volume;

	@NotNull
	private float weight;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="packaging")
	private List<CustomerOrder> customersOrders;

	//bi-directional many-to-one association to Truck
	@ManyToOne
	@JoinColumn(name="id_truck")
	private Truck truck;

	public Packaging() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackagingType() {
		return this.packagingType;
	}

	public void setPackagingType(String packagingType) {
		this.packagingType = packagingType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getVolume() {
		return this.volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<CustomerOrder> getCustomersOrders() {
		return this.customersOrders;
	}

	public void setCustomersOrders(List<CustomerOrder> customersOrders) {
		this.customersOrders = customersOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().add(customerOrder);
		customerOrder.setPackaging(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().remove(customerOrder);
		customerOrder.setPackaging(null);

		return customerOrder;
	}

	public Truck getTruck() {
		return this.truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

}