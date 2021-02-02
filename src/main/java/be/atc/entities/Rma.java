package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the rma database table.
 * 
 */
@Entity
@NamedQuery(name="Rma.findAll", query="SELECT r FROM Rma r")
public class Rma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to Returns
	@ManyToOne
	@JoinColumn(name="id_returns")
	private Returns returns;

	public Rma() {
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

	public Returns getReturns() {
		return this.returns;
	}

	public void setReturns(Returns returns) {
		this.returns = returns;
	}

}