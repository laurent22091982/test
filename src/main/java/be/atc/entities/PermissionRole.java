package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissions_roles database table.
 * 
 */
@Entity
@Table(name="permissions_roles")
@NamedQuery(name="PermissionRole.findAll", query="SELECT p FROM PermissionRole p")
public class PermissionRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	@JoinColumn(name="id_permission")
	private Permission permission;

	public PermissionRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}