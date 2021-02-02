package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the suppliers_orders_items database table.
 * 
 */
@Entity
@Table(name="suppliers_orders_items")
@NamedQuery(name="SupplierOrderItem.findAll", query="SELECT s FROM SupplierOrderItem s")
public class SupplierOrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	private int quantity;

	//bi-directional many-to-one association to SupplierOrder
	@ManyToOne
	@JoinColumn(name="id_supplier_order")
	private SupplierOrder supplierOrder;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	public SupplierOrderItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SupplierOrder getSupplierOrder() {
		return this.supplierOrder;
	}

	public void setSuppliersOrder(SupplierOrder supplierOrder) {
		this.supplierOrder = supplierOrder;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}