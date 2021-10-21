package com.qa.ims.persistence.domain;

public class Item {
	

	private Long itemId;
	private String itemName;
	private float price;
	
	
	public Item(Long itemId, String itemName, float price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;	
	
	}
	
		public Item(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
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

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + "]";
		}

		
		
}
