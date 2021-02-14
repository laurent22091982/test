package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :userMail")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean active;

	@Size(max = 30)
	@Column(name="business_number")
	private String businessNumber;

	@NotNull
	@Size(min = 2, max = 100)
	private String firstname;

	@NotNull
	@Size(min = 2, max = 100)
	private String lastname;

	@NotNull
	@Email
	private String mail;

	@NotNull
	private String password;

	@Lob
	private byte[] salt;

	@Size(max = 30)
	@Column(name="vat_number")
	private String vatNumber;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="user")
	private List<CustomerOrder> customersOrders;

	//bi-directional many-to-one association to SupplierOrder
	@OneToMany(mappedBy="user")
	private List<SupplierOrder> suppliersOrders;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	//bi-directional many-to-one association to UserAddress
	@OneToMany(mappedBy="user")
	private List<UserAddress> usersAddresses;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) { this.active = active; }

	public String getBusinessNumber() {
		return this.businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return this.salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getVatNumber() {
		return this.vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public List<CustomerOrder> getCustomersOrders() {
		return this.customersOrders;
	}

	public void setCustomersOrders(List<CustomerOrder> customersOrders) {
		this.customersOrders = customersOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().add(customerOrder);
		customerOrder.setUser(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomersOrders().remove(customerOrder);
		customerOrder.setUser(null);

		return customerOrder;
	}

	public List<SupplierOrder> getSuppliersOrders() {
		return this.suppliersOrders;
	}

	public void setSuppliersOrders(List<SupplierOrder> suppliersOrders) {
		this.suppliersOrders = suppliersOrders;
	}

	public SupplierOrder addSupplierOrder(SupplierOrder supplierOrder) {
		getSuppliersOrders().add(supplierOrder);
		supplierOrder.setUser(this);

		return supplierOrder;
	}

	public SupplierOrder removeSupplierOrder(SupplierOrder supplierOrder) {
		getSuppliersOrders().remove(supplierOrder);
		supplierOrder.setUser(null);

		return supplierOrder;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<UserAddress> getUsersAddresses() {
		return this.usersAddresses;
	}

	public void setUsersAddresses(List<UserAddress> usersAddresses) {
		this.usersAddresses = usersAddresses;
	}

	public UserAddress addUserAddress(UserAddress userAddress) {
		getUsersAddresses().add(userAddress);
		userAddress.setUser(this);

		return userAddress;
	}

	public UserAddress removeUserAddress(UserAddress userAddress) {
		getUsersAddresses().remove(userAddress);
		userAddress.setUser(null);

		return userAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return active == user.active && Objects.equals(id, user.id) && Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) && Objects.equals(mail, user.mail) && Objects.equals(password, user.password) && Arrays.equals(salt, user.salt) && Objects.equals(vatNumber, user.vatNumber) && Objects.equals(businessNumber, user.businessNumber);
	}

	@Override
	public int hashCode() { return Objects.hash(id, lastname, firstname, mail); }

}