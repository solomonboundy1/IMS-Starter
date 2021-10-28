package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDao DAO = new OrderDao();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Customer cust = new Customer();
		final Order created = new Order(cust);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		final Customer cus = new Customer();
		final Item item = new Item();
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, cus , 1l, 4.99d, item));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		final Customer cus = new Customer();
		final Item item = new Item();
		assertEquals(new Order(1L, cus, 1l, 4.99d, item), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final Customer cus = new Customer();
		final Item item = new Item();
		final Long ID = 1L;
		assertEquals(new Order(ID, cus, 1L, 4.99, item), DAO.read(ID));
	}
	
	
}	

