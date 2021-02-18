package be.atc.beans;

import be.atc.entities.Category;
import be.atc.entities.Item;
import be.atc.services.CategoryService;
import be.atc.services.ItemService;
import be.atc.utils.MenuUtils;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CatalogBean implements Serializable {

    CategoryService categoryService = new CategoryService();
    ItemService itemService = new ItemService();

    List<Category> categoryList = categoryService.findAllCategory();

    List<Item> itemList = new ArrayList<>();

    public void completeItem(){
        itemList = itemService.findAllItem();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
