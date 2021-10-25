package com.qa.ims.persistence.domain;

public class Item {

	private Long itemId;
	private String itemName;
	private Double price;

	public Item(Long itemId, String itemName, Double price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;

	}

	public Item(String itemName, Double price2) {
		this.itemName = itemName;
		this.price = price2;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	} 

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + "]";
	}

}
