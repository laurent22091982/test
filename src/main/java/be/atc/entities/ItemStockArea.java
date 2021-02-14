package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * The persistent class for the items_stocks_areas database table.
 *
 */
@Entity
@Table(name="items_stocks_areas")
@NamedQuery(name="ItemStockArea.findAll", query="SELECT i FROM ItemStockArea i")
public class ItemStockArea implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int quantity;

    //bi-directional many-to-one association to Item
    @ManyToOne
    @JoinColumn(name="id_item")
    private Item item;

    //bi-directional many-to-one association to StockArea
    @ManyToOne
    @JoinColumn(name="id_stock_area")
    private StockArea stockArea;

    public ItemStockArea() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public StockArea getStockArea() {
        return this.stockArea;
    }

    public void setStockArea(StockArea stockArea) {
        this.stockArea = stockArea;
    }

}