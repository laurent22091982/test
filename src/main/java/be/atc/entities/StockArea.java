package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the stocks database table.
 * 
 */
@Entity
@Table(name="stocks_areas")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM StockArea s")
public class StockArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 100)
	private String label;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="stockArea")
	private List<ItemStockArea> itemsStocksAreas;

	public StockArea() {
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

	public List<ItemStockArea> getItemsStocksAreas() {
		return this.itemsStocksAreas;
	}

	public void setItemsStocksAreas(List<ItemStockArea> itemsStocksAreas) {
		this.itemsStocksAreas = itemsStocksAreas;
	}

	public ItemStockArea addItemStockArea(ItemStockArea itemStockArea) {
		getItemsStocksAreas().add(itemStockArea);
		itemStockArea.setStockArea(this);

		return itemStockArea;
	}

	public ItemStockArea removeItemStockArea(ItemStockArea itemStockArea) {
		getItemsStocksAreas().remove(itemStockArea);
		itemStockArea.setStockArea(null);

		return itemStockArea;
	}
}