package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_addresses database table.
 * 
 */
@Entity
@Table(name="users_addresses")
@NamedQuery(name="UserAddress.findAll", query="SELECT u FROM UserAddress u")
public class UserAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="id_address")
	private Address address;

	public UserAddress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}