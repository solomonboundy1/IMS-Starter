package com.qa.ims.persistence.domain;

public class Orders_Items {
	
	int ordersItemsId; 
	Order orderId;
	Item itemId;
	public Orders_Items(int ordersItemsId, Order orderId, Item itemId) {
		this.ordersItemsId = ordersItemsId;
		this.orderId = orderId;
		this.itemId = itemId;
	}
	public Orders_Items(Order orderId, Item itemId) {
		this.orderId = orderId;
		this.itemId = itemId;
	}
	public int getOrdersItemsId() {
		return ordersItemsId;
	}
	public void setOrdersItemsId(int ordersItemsId) {
		this.ordersItemsId = ordersItemsId;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public Item getItemId() {
		return itemId;
	}
	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "Orders_Items [ordersItemsId=" + ordersItemsId + ", orderId=" + orderId + ", itemId=" + itemId + "]";
	}
	
	

}
