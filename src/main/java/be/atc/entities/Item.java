package be.atc.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


/**
 * The persistent class for the items database table.
 * 
 */
@Entity
@Table(name="items")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	private boolean active;

	@NotNull
	private int barcode;

	private String description;

	@NotNull
	@Size(min = 2, max = 100)
	private String designation;

	@Column(name="picture_url")
	private String pictureUrl;

	@NotNull
	private float price;

	@NotNull
	private float volume;

	@NotNull
	private float weight;

	//bi-directional many-to-one association to ItemStockArea
	@OneToMany(mappedBy="item")
	private List<ItemStockArea> itemsStocksAreas;

	//bi-directional many-to-one association to ItemElement
	@OneToMany(mappedBy="item")
	private List<ItemElement> itemsElements;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="id_brand")
	private Brand brand;

	//bi-directional many-to-one association to ItemCategory
	@OneToMany(mappedBy="item")
	private List<ItemCategory> itemsCategories;

	//bi-directional many-to-one association to SupplierOrderItem
	@OneToMany(mappedBy="item")
	private List<SupplierOrderItem> suppliersOrdersItems;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getBarcode() {
		return this.barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getVolume() {
		return this.volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<ItemStockArea> getItemsStocksAreas() {
		return this.itemsStocksAreas;
	}

	public void setItemsStocksAreas(List<ItemStockArea> itemsStocksAreas) {
		this.itemsStocksAreas = itemsStocksAreas;
	}

	public ItemStockArea addItemStockArea(ItemStockArea itemStockArea) {
		getItemsStocksAreas().add(itemStockArea);
		itemStockArea.setItem(this);

		return itemStockArea;
	}

	public ItemStockArea removeItemStockArea(ItemStockArea itemStockArea) {
		getItemsStocksAreas().remove(itemStockArea);
		itemStockArea.setItem(null);

		return itemStockArea;
	}

	public List<ItemElement> getItemsElements() {
		return this.itemsElements;
	}

	public void setItemElements(List<ItemElement> itemsElements) {
		this.itemsElements = itemsElements;
	}

	public ItemElement addItemElement(ItemElement itemElement) {
		getItemsElements().add(itemElement);
		itemElement.setItem(this);

		return itemElement;
	}

	public ItemElement removeItemElement(ItemElement itemElement) {
		getItemsElements().remove(itemElement);
		itemElement.setItem(null);

		return itemElement;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<ItemCategory> getItemsCategories() {
		return this.itemsCategories;
	}

	public void setItemsCategories(List<ItemCategory> itemsCategories) {
		this.itemsCategories = itemsCategories;
	}

	public ItemCategory addItemCategory(ItemCategory itemCategory) {
		getItemsCategories().add(itemCategory);
		itemCategory.setItem(this);

		return itemCategory;
	}

	public ItemCategory removeItemCategory(ItemCategory itemCategory) {
		getItemsCategories().remove(itemCategory);
		itemCategory.setItem(null);

		return itemCategory;
	}

	public List<SupplierOrderItem> getSuppliersOrdersItems() {
		return this.suppliersOrdersItems;
	}

	public void setSuppliersOrdersItems(List<SupplierOrderItem> suppliersOrdersItems) {
		this.suppliersOrdersItems = suppliersOrdersItems;
	}

	public SupplierOrderItem addSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
		getSuppliersOrdersItems().add(supplierOrderItem);
		supplierOrderItem.setItem(this);

		return supplierOrderItem;
	}

	public SupplierOrderItem removeSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
		getSuppliersOrdersItems().remove(supplierOrderItem);
		supplierOrderItem.setItem(null);

		return supplierOrderItem;
	}

}