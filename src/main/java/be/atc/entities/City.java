package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the cities database table.
 * 
 */
@Entity
@Table(name="cities")
@NamedQueries({
		@NamedQuery(name = "City.findAll", query = "SELECT c FROM City c ORDER BY c.zipCode"),
		@NamedQuery(name = "City.findZipCode", query = "SELECT c FROM City c WHERE c.zipCode LIKE :zipCode ORDER BY c.zipCode")
})

public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	@NotNull
	@Size(min = 2, max = 10)
	@Column(name="zip_code")
	private String zipCode;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="city")
	private List<Address> addresses;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	public City() {
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

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCity(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCity(null);

		return address;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof City)) {
			return false;
		}
		City other = (City) obj;
		if ((this.id == 0 && other.id != 0) || (this.id != 0 && this.id != other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()  {
		return Objects.hash(id, label, zipCode);
	}

	@Override
	public String toString() {
		return String.valueOf(getId());
	}
}