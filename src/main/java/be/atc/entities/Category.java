package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to ItemCategory
	@OneToMany(mappedBy="category")
	private List<ItemCategory> itemsCategories;

	public Category() {
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

	public List<ItemCategory> getItemsCategories() {
		return this.itemsCategories;
	}

	public void setItemsCategories(List<ItemCategory> itemsCategories) {
		this.itemsCategories = itemsCategories;
	}

	public ItemCategory addItemCategory(ItemCategory itemCategory) {
		getItemsCategories().add(itemCategory);
		itemCategory.setCategory(this);

		return itemCategory;
	}

	public ItemCategory removeItemCategory(ItemCategory itemCategory) {
		getItemsCategories().remove(itemCategory);
		itemCategory.setCategory(null);

		return itemCategory;
	}

}