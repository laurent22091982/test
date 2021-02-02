package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * The persistent class for the baskets database table.
 * 
 */
@Entity
@Table(name="baskets")
@NamedQuery(name="Basket.findAll", query="SELECT b FROM Basket b")
public class Basket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 3, max = 100)
	private String label;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to BasketItem
	@OneToMany(mappedBy="basket")
	private List<BasketItem> basketsItems;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="basket")
	private List<CustomerOrder> customersOrders;

	public Basket() {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BasketItem> getBasketsItems() {
		return this.basketsItems;
	}

	public void setBasketsItems(List<BasketItem> basketsItems) {
		this.basketsItems = basketsItems;
	}

	public BasketItem addBasketItem(BasketItem basketItem) {
		getBasketsItems().add(basketItem);
		basketItem.setBasket(this);

		return basketItem;
	}

	public BasketItem removeBasketItem(BasketItem basketItem) {
		getBasketsItems().remove(basketItem);
		basketItem.setBasket(null);

		return basketItem;
	}

	public List<CustomerOrder> getCustomersOrders() {
		return this.customersOrders;
	}

	public void setCustomersOrders(List<CustomerOrder> customersOrders) {
		this.customersOrders = customersOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().add(customerOrder);
		customerOrder.setBasket(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().remove(customerOrder);
		customerOrder.setBasket(null);

		return customerOrder;
	}

}