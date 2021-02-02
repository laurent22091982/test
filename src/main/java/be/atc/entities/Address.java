package be.atc.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name="addresses")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Size(max = 6)
	private String postbox;

	@NotNull
	@Size(min = 1, max = 6)
	private String postnumber;

	@NotNull
	@Size(min = 4, max = 100)
	private String street;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="id_city")
	private City city;

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostbox() {
		return this.postbox;
	}

	public void setPostbox(String postbox) {
		this.postbox = postbox;
	}

	public String getPostnumber() {
		return this.postnumber;
	}

	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(postnumber, address.postnumber) && Objects.equals(postbox, address.postbox);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, street, postnumber, postbox);
	}

	@Override
	public String toString() {
		return getStreet() + getPostnumber() + getPostbox();
	}

}