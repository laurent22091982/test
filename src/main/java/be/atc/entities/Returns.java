package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * The persistent class for the returns database table.
 * 
 */
@Entity
@Table(name="returns")
@NamedQuery(name="Return.findAll", query="SELECT r FROM Returns r")
public class Returns implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to ItemElement
	@OneToMany(mappedBy="returns")
	private List<ItemElement> itemElements;

	//bi-directional many-to-one association to Rma
	@OneToMany(mappedBy="returns")
	private List<Rma> rmas;

	public Returns() {
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
		itemElement.setReturns(this);

		return itemElement;
	}

	public ItemElement removeItemElement(ItemElement itemElement) {
		getItemElements().remove(itemElement);
		itemElement.setReturns(null);

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
		rma.setReturns(this);

		return rma;
	}

	public Rma removeRma(Rma rma) {
		getRmas().remove(rma);
		rma.setReturns(null);

		return rma;
	}

}