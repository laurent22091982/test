package be.atc.entities;

import be.atc.enumerations.StatusEnum;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the customers_orders database table.
 * 
 */
@Entity
@Table(name="customers_orders")
@NamedQuery(name="CustomerOrder.findAll", query="SELECT c FROM CustomerOrder c")
public class CustomerOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name="order_date")
	private LocalDateTime orderDate;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@NotNull
	@Column(name="total_price")
	private float totalPrice;

	@NotNull
	@Column(name="total_weight")
	private float totalWeight;

	@NotNull
	@Column(name="total_volume")
	private float totalVolume;

	//bi-directional many-to-one association to ShippingOption
	@ManyToOne
	@JoinColumn(name="id_shipping_option")
	private ShippingOption shippingOption;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Packaging
	@ManyToOne
	@JoinColumn(name="id_packaging")
	private Packaging packaging;

	//bi-directional many-to-one association to CustomerOrderDocumentType
	@OneToMany(mappedBy="customerOrder")
	private List<CustomerOrderDocumentType> customersOrdersDocumentsTypes;

	//bi-directional many-to-one association to ItemElement
	@OneToMany(mappedBy="customerOrder")
	private List<ItemElement> itemsElements;

	public CustomerOrder() {
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

	public StatusEnum getStatus() { return status; }

	public void setStatus(StatusEnum status) { this.status = status; }

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }

	public float getTotalWeight() { return totalWeight; }

	public void setTotalWeight(float totalWeight) { this.totalWeight = totalWeight; }

	public float getTotalVolume() { return totalVolume; }

	public void setTotalVolume(float totalVolume) { this.totalVolume = totalVolume; }

	public ShippingOption getShippingOption() {
		return this.shippingOption;
	}

	public void setShippingOption(ShippingOption shippingOption) {
		this.shippingOption = shippingOption;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Packaging getPackaging() {
		return this.packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public List<CustomerOrderDocumentType> getCustomersOrdersDocumentsTypes() {
		return this.customersOrdersDocumentsTypes;
	}

	public void setCustomersOrdersDocumentsTypes(List<CustomerOrderDocumentType> customersOrdersDocumentsTypes) {
		this.customersOrdersDocumentsTypes = customersOrdersDocumentsTypes;
	}

	public CustomerOrderDocumentType addCustomerOrderDocumentType(CustomerOrderDocumentType customerOrderDocumentType) {
		getCustomersOrdersDocumentsTypes().add(customerOrderDocumentType);
		customerOrderDocumentType.setCustomerOrder(this);

		return customerOrderDocumentType;
	}

	public CustomerOrderDocumentType removeCustomerOrderDocumentType(CustomerOrderDocumentType customerOrderDocumentType) {
		getCustomersOrdersDocumentsTypes().remove(customerOrderDocumentType);
		customerOrderDocumentType.setCustomerOrder(null);

		return customerOrderDocumentType;
	}

	public List<ItemElement> getItemsElements() {
		return this.itemsElements;
	}

	public void setItemsElements(List<ItemElement> itemsElements) {
		this.itemsElements = itemsElements;
	}

	public ItemElement addItemElement(ItemElement itemElement) {
		getItemsElements().add(itemElement);
		itemElement.setCustomerOrder(this);

		return itemElement;
	}

	public ItemElement removeItemElement(ItemElement itemElement) {
		getItemsElements().remove(itemElement);
		itemElement.setCustomerOrder(null);

		return itemElement;
	}

}