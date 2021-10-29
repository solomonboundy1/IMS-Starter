package com.qa.ims.persistence.domain;

import java.util.Objects;

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
	
	public Item() {
		
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

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(price, other.price);
	}
	
	

}
