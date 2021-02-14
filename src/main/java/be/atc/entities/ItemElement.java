package be.atc.entities;

import be.atc.enumerations.StatusEnum;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * The persistent class for the items_elements database table.
 * 
 */
@Entity
@Table(name="items_elements")
@NamedQuery(name="ItemElement.findAll", query="SELECT i FROM ItemElement i")
public class ItemElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@NotNull
	private float price;

	@NotNull
	private int quantity;

	//bi-directional many-to-one association to CustomerOrder
	@ManyToOne
	@JoinColumn(name="id_customer_order")
	private CustomerOrder customerOrder;

	//bi-directional many-to-one association to ReturnItem
	@ManyToOne
	@JoinColumn(name="id_return_item")
	private ReturnItem returnItem;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	public ItemElement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusEnum getStatus() { return status; }

	public void setStatus(StatusEnum status) { this.status = status; }

	public float getPrice() { return price; }

	public void setPrice(float price) { this.price = price; }

	public int getQuantity() { return quantity; }

	public void setQuantity(int quantity) { this.quantity = quantity; }

	public CustomerOrder getCustomerOrder() {
		return this.customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public ReturnItem getReturnItem() {
		return this.returnItem;
	}

	public void setReturnItem(ReturnItem returnItem) {
		this.returnItem = returnItem;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}