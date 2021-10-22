package com.qa.ims.persistence.domain;

public class Order {
	
	int OrdersId;
	Customer CustomerId;
	int itemQuantity;
	float total;
	
	
	public Order(int ordersId, Customer customerId, int itemQuantity, float total) {
		OrdersId = ordersId;
		CustomerId = customerId;
		this.itemQuantity = itemQuantity;
		this.total = total;
	}
	
	public Order(Customer customerId, int itemQuantity, float total) {
		CustomerId = customerId;
		this.itemQuantity = itemQuantity;
		this.total = total;
	}

	public int getOrdersId() {
		return OrdersId;
	}

	public void setOrdersId(int ordersId) {
		OrdersId = ordersId;
	}

	public Customer getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Customer customerId) {
		CustomerId = customerId;
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

	@Override
	public String toString() {
		return "Order [OrdersId=" + OrdersId + ", CustomerId=" + CustomerId + ", itemQuantity=" + itemQuantity
				+ ", total=" + total + "]";
	}
	
	
} 
