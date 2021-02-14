package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the returns_items database table.
 * 
 */
@Entity
@Table(name="returns_items")
@NamedQuery(name="ReturnItem.findAll", query="SELECT r FROM ReturnItem r")
public class ReturnItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to ItemElement
	@OneToMany(mappedBy="returnItem")
	private List<ItemElement> itemsElements;

	//bi-directional many-to-one association to Rma
	@OneToMany(mappedBy="returnItem")
	private List<Rma> rmas;

	public ReturnItem() {
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

	public List<ItemElement> getItemsElements() {
		return this.itemsElements;
	}

	public void setItemsElements(List<ItemElement> itemsElements) {
		this.itemsElements = itemsElements;
	}

	public ItemElement addItemElement(ItemElement itemElement) {
		getItemsElements().add(itemElement);
		itemElement.setReturnItem(this);

		return itemElement;
	}

	public ItemElement removeItemElement(ItemElement itemElement) {
		getItemsElements().remove(itemElement);
		itemElement.setReturnItem(null);

		return itemElement;
	}

	public List<Rma> getRmas() {
		return this.rmas;
	}

	public void setRmas(List<Rma> rmas) {
		this.rmas = rmas;
	}

	public Rma addRma(Rma rma) {
		getRmas().add(rma);
		rma.setReturnItem(this);

		return rma;
	}

	public Rma removeRma(Rma rma) {
		getRmas().remove(rma);
		rma.setReturnItem(null);

		return rma;
	}

}