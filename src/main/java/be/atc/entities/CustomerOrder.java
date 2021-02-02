package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
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


	@Column(name="order_date")
	private LocalDateTime orderDate;

	//bi-directional many-to-one association to ShippingOption
	@ManyToOne
	@JoinColumn(name="id_shipping_option")
	private ShippingOption shippingOption;

	//bi-directional many-to-one association to Basket
	@ManyToOne
	@JoinColumn(name="id_basket")
	private Basket basket;

	//bi-directional many-to-one association to Packaging
	@ManyToOne
	@JoinColumn(name="id_packaging")
	private Packaging packaging;

	//bi-directional many-to-one association to CustomerOrderDocumentType
	@OneToMany(mappedBy="customerOrder")
	private List<CustomerOrderDocumentType> customersOrdersDocumentsTypes;

	//bi-directional many-to-one association to ItemElement
	@OneToMany(mappedBy="customerOrder")
	private List<ItemElement> itemElements;

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

	public ShippingOption getShippingOption() {
		return this.shippingOption;
	}

	public void setShippingOption(ShippingOption shippingOption) {
		this.shippingOption = shippingOption;
	}

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
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

	public List<ItemElement> getItemElements() {
		return this.itemElements;
	}

	public void setItemElements(List<ItemElement> itemElements) {
		this.itemElements = itemElements;
	}

	public ItemElement addItemElement(ItemElement itemElement) {
		getItemElements().add(itemElement);
		itemElement.setCustomerOrder(this);

		return itemElement;
	}

	public ItemElement removeItemElement(ItemElement itemElement) {
		getItemElements().remove(itemElement);
		itemElement.setCustomerOrder(null);

		return itemElement;
	}

}