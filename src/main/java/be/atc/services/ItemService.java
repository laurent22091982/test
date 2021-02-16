package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import be.atc.entities.Item;

import java.util.List;

/**
 * @author Gravez Laurent
 *
 */

public class ItemService {

    public List<be.atc.entities.Item> findAllItem() {
        List<Item> itemList;
        EntityFinder<Item> ef = new EntityFinderImpl<>();
        itemList = ef.findByNamedQuery("Item.findAll", new Item(), null);
        return itemList;
    }
}