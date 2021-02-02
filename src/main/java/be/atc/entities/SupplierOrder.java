package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the suppliers_orders database table.
 * 
 */
@Entity
@Table(name="suppliers_orders")
@NamedQuery(name="SupplierOrder.findAll", query="SELECT s FROM SupplierOrder s")
public class SupplierOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name="order_date")
	private LocalDateTime orderDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="id_supplier")
	private Supplier supplier;

	//bi-directional many-to-one association to SupplierOrderItem
	@OneToMany(mappedBy="supplierOrder")
	private List<SupplierOrderItem> suppliersOrdersItems;

	public SupplierOrder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<SupplierOrderItem> getSuppliersOrdersItems() {
		return this.suppliersOrdersItems;
	}

	public void setSuppliersOrdersItems(List<SupplierOrderItem> suppliersOrdersItems) {
		this.suppliersOrdersItems = suppliersOrdersItems;
	}

	public SupplierOrderItem addSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
		getSuppliersOrdersItems().add(supplierOrderItem);
		supplierOrderItem.setSuppliersOrder(this);

		return supplierOrderItem;
	}

	public SupplierOrderItem removeSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
		getSuppliersOrdersItems().remove(supplierOrderItem);
		supplierOrderItem.setSuppliersOrder(null);

		return supplierOrderItem;
	}

}