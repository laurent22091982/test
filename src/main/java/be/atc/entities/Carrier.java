package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * The persistent class for the carriers database table.
 * 
 */
@Entity
@Table(name="carriers")
@NamedQuery(name="Carrier.findAll", query="SELECT c FROM Carrier c")
public class Carrier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	private boolean active;

	@Size(max = 30)
	@Column(name="bank_account")
	private String bankAccount;

	@Size(max = 30)
	@Column(name="business_number")
	private String businessNumber;

	@Size(max = 100)
	@Column(name="contact_person")
	private String contactPerson;

	@NotNull
	@Email
	private String mail;

	@NotNull
	@Size(max = 100)
	private String name;

	@NotNull
	@Size(max = 30)
	private String phone;

	@Size(max = 30)
	@Column(name="vat_number")
	private String vatNumber;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="id_address")
	private Address address;

	//bi-directional many-to-one association to Truck
	@OneToMany(mappedBy="carrier")
	private List<Truck> trucks;

	public Carrier() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBusinessNumber() {
		return this.businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVatNumber() {
		return this.vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Truck> getTrucks() {
		return this.trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

	public Truck addTruck(Truck truck) {
		getTrucks().add(truck);
		truck.setCarrier(this);

		return truck;
	}

	public Truck removeTruck(Truck truck) {
		getTrucks().remove(truck);
		truck.setCarrier(null);

		return truck;
	}

}