package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.Category;

import java.util.List;

/**
 * @author Gravez Laurent
 *
 */

public class CategoryService {

    public List<be.atc.entities.Category> findAllCategory() {
        List<Category> categoryList;
        EntityFinder<Category> ef = new EntityFinderImpl<>();
        categoryList = ef.findByNamedQuery("Category.findAll", new Category(), null);
        return categoryList;
    }
}