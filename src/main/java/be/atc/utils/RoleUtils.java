package be.atc.utils;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.Role;

/**
 * @author Gautier Olivier
 *
 */

public class RoleUtils {

    public static Role findOneRole(int id) {
        Role role;
        EntityFinder<Role> ef = new EntityFinderImpl<Role>();
        role = ef.findOne(new Role(), id);

        return role;
    }
}
