package com.qa.ims.persistence.domain;

public class Order {
	
	private Long ordersId;
	private Customer customer;
	private int itemQuantity;
	private float total;
	private Item item;
	
	
	
	public Order(Long orderId, Customer customer, int itemQuantity, float total, Item item) {
		this.ordersId = orderId;
		this.customer = customer;
		this.itemQuantity = itemQuantity;
		this.total = total;
		this.item = item;
	}
	
	


	public Order(Customer customer, int itemQuantity, float total, Item item) {
		this.customer = customer;
		this.itemQuantity = itemQuantity;
		this.total = total;
		this.item = item;
	}




	public Long getOrdersId() {
		return ordersId;
	}



	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public int getItemQuantity() {
		return itemQuantity;
	}



	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



	public float getTotal() {
		return total;
	}



	public void setTotal(float total) {
		this.total = total;
	}



	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	@Override
	public String toString() {
		return "Order [ordersId=" + ordersId + ", customer=" + customer + ", itemQuantity=" + itemQuantity + ", total="
				+ total + ", item=" + item + "]";
	}
	
	
	
	
	
} 
