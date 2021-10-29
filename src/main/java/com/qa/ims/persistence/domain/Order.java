package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long ordersId;
	private Customer customer;
	private Long itemQuantity;
	private Double total;
	private Item item;
	
	
	
	public Order(Long ordersId, Long itemQuantity, Double total, Item item) {
		
		this.ordersId = ordersId;
		this.itemQuantity = itemQuantity;
		this.total = total;
		this.item = item;
	}




	public Order(Long orderId, Customer customer, Long itemQuantity2, Double total2, Item item) {
		this.ordersId = orderId;
		this.customer = customer;
		this.itemQuantity = itemQuantity2;
		this.total = total2;
		this.item = item;
	}
	
	


	public Order(Long ordersId, Long itemQuantity, Double total) {
		this.ordersId = ordersId;
		this.itemQuantity = itemQuantity;
		this.total = total;
	}




	public Order(Customer customer, Long itemQuantity, Double total, Item item) {
		this.customer = customer;
		this.itemQuantity = itemQuantity;
		this.total = total;
		this.item = item;
	}

	public Order(Customer customer) {
		this.customer = customer;
	}


	public Order(Long ordersId, Item item) {
		super();
		this.ordersId = ordersId;
		this.item = item;
	}
	
	


	public Order(Long ordersId, Customer customer) {
		super();
		this.ordersId = ordersId;
		this.customer = customer;
	}




	public Order(Long ordersId, Customer customer, Long itemQuantity, Double total) {
		this.ordersId = ordersId;
		this.customer = customer;
		this.itemQuantity = itemQuantity;
		this.total = total;
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



	public Long getItemQuantity() {
		return itemQuantity;
	}



	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
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




	@Override
	public int hashCode() {
		return Objects.hash(customer, item, itemQuantity, ordersId, total);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(item, other.item)
				&& Objects.equals(itemQuantity, other.itemQuantity) && Objects.equals(ordersId, other.ordersId)
				&& Objects.equals(total, other.total);
	}
	
	
	
	
	
} 
