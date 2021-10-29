package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDao dao;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		
		final Customer customer = new Customer(1L, "jordan", "harrison");
		
		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(dao.create(Mockito.any())).thenReturn(new Order(customer));
		assertEquals(new Order(customer), controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(new Order(customer));
	}
	
	
	@Test
	public void testReadAll() {
		final Customer customer = new Customer(1L, "jordan", "harrison");
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(customer));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	
	
//	@Test
//	public void testUpdate() {
//		
//		Item item = new Item();
//		Customer customer = new Customer(1L, "jordan", "harrison");
//		Long custId = 1l;
//		CustomerDAO customerdao = new CustomerDAO();
//		Customer customer1 = new CustomerDAO().read(custId);
//		Order updated = new Order(1l, customer1, 1L, 12.99);
// 
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getString()).thenReturn("UPDATE QUANTITY");
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getDouble()).thenReturn(12.99);
//		Mockito.when(this.utils.getLong()).thenReturn(1l);
////		Mockito.when(this.utils.getLong()).thenReturn(updated.getCustomer().getId());
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.utils, Mockito.times(1)).getString();
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}
//	
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	
}