package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the items_categories database table.
 * 
 */
@Entity
@Table(name="items_categories")
@NamedQuery(name="ItemCategory.findAll", query="SELECT i FROM ItemCategory i")
public class ItemCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Category category;

	public ItemCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}