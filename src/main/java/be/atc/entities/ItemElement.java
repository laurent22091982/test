package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the item_elements database table.
 * 
 */
@Entity
@Table(name="item_elements")
@NamedQuery(name="ItemElement.findAll", query="SELECT i FROM ItemElement i")
public class ItemElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	private boolean active;

	private int barcode;

	//bi-directional many-to-one association to CustomerOrder
	@ManyToOne
	@JoinColumn(name="id_customer_order")
	private CustomerOrder customerOrder;

	//bi-directional many-to-one association to Returns
	@ManyToOne
	@JoinColumn(name="id_returns")
	private Returns returns;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="id_stock")
	private Stock stock;

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

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getBarcode() {
		return this.barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public CustomerOrder getCustomerOrder() {
		return this.customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public Returns getReturns() {
		return this.returns;
	}

	public void setReturns(Returns returns) {
		this.returns = returns;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}