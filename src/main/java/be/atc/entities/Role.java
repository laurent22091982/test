package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to PermissionRole
	@OneToMany(mappedBy="role")
	private List<PermissionRole> permissionsRoles;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	private List<User> users;

	public Role() {
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

	public List<PermissionRole> getPermissionsRoles() {
		return this.permissionsRoles;
	}

	public void setPermissionsRoles(List<PermissionRole> permissionsRoles) {
		this.permissionsRoles = permissionsRoles;
	}

	public PermissionRole addPermissionRole(PermissionRole permissionRole) {
		getPermissionsRoles().add(permissionRole);
		permissionRole.setRole(this);

		return permissionRole;
	}

	public PermissionRole removePermissionRole(PermissionRole permissionRole) {
		getPermissionsRoles().remove(permissionRole);
		permissionRole.setRole(null);

		return permissionRole;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

}