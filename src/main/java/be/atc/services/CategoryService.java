package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.Category;

import java.util.List;

public class CategoryService {

    public List<be.atc.entities.Category> findAllCategory() {
        List<be.atc.entities.Category> categoryList;
        EntityFinder<be.atc.entities.Category> ef = new EntityFinderImpl<>();
        categoryList = ef.findByNamedQuery("Category.findAll", new Category(), null);
        return categoryList;
    }

}
