package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * The persistent class for the stocks database table.
 * 
 */
@Entity
@Table(name="stocks")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to ItemElement
	@OneToMany(mappedBy="stock")
	private List<ItemElement> itemElements;

	public Stock() {
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

	public List<ItemElement> getItemElements() {
		return this.itemElements;
	}

	public void setItemElements(List<ItemElement> itemElements) {
		this.itemElements = itemElements;
	}

	public ItemElement addItemElement(ItemElement itemElement) {
		getItemElements().add(itemElement);
		itemElement.setStock(this);

		return itemElement;
	}

	public ItemElement removeItemElement(ItemElement itemElement) {
		getItemElements().remove(itemElement);
		itemElement.setStock(null);

		return itemElement;
	}

}