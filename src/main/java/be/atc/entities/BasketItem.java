package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the baskets_items database table.
 * 
 */
@Entity
@Table(name="baskets_items")
@NamedQuery(name="BasketItem.findAll", query="SELECT b FROM BasketItem b")
public class BasketItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	private int quantity;

	//bi-directional many-to-one association to Basket
	@ManyToOne
	@JoinColumn(name="id_basket")
	private Basket basket;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	public BasketItem() {
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

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}