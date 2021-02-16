package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.Role;

/**
 * @author Gautier Olivier
 *
 */

public class RoleServices {

    public static Role findOneRole(int id) {
        Role role;
        EntityFinder<Role> ef = new EntityFinderImpl<>();
        role = ef.findOne(new Role(), id);

        return role;
    }
}
