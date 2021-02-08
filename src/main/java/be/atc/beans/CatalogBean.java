package be.atc.beans;

import be.atc.entities.Category;
import be.atc.entities.Item;
import be.atc.services.CategoryService;
import be.atc.services.ItemService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CatalogBean implements Serializable {

    ItemService is = new ItemService();
    CategoryService cs = new CategoryService();

    public List<Category> getCategoryList(){
        return cs.findAllCategory();
    }

    public List<Item> getItemList(){
        return is.findAllItem();
    }


}
