package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the shippings_options database table.
 * 
 */
@Entity
@Table(name="shippings_options")
@NamedQuery(name="ShippingOption.findAll", query="SELECT s FROM ShippingOption s")
public class ShippingOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="shippingOption")
	private List<CustomerOrder> customersOrders;

	public ShippingOption() {
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

	public List<CustomerOrder> getCustomersOrders() {
		return this.customersOrders;
	}

	public void setCustomersOrders(List<CustomerOrder> customersOrders) {
		this.customersOrders = customersOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().add(customerOrder);
		customerOrder.setShippingOption(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().remove(customerOrder);
		customerOrder.setShippingOption(null);

		return customerOrder;
	}

}