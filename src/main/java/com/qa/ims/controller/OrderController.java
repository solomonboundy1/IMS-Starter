package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDao orderDao;
	private Utils utils;
	

	public OrderController(OrderDao orderDao, Utils utils) {
		this.orderDao = orderDao;
		this.utils = utils;
	}

	
	
	
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDao.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	
	
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer ID");
		Long custId = utils.getLong();
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.read(custId);
		Order newOrder = new Order(customer);
		
		Order order = orderDao.create(newOrder);
		
		return order;
		
		
	}

	

	@Override
	public Order update() {
		LOGGER.info("Enter UPDATE QUANTITY if you would like to update the order with the item quantity and total, enter ADD if you would like to add an item to the order, enter REMOVE if you would like to remove an item from the order or enter DONE if you are finished");
		String reply = utils.getString();
		
		if (reply.equalsIgnoreCase("UPDATE QUANTITY")) {
			
			LOGGER.info("Please enter the quantity of the item");
			Long quant = utils.getLong();
			LOGGER.info("Please enter the total cost");
			double total = utils.getDouble();
			LOGGER.info("Please enter the order ID");
			Long ordId = utils.getLong();
			
			Order order =  orderDao.update(new Order(ordId, quant, total));
			LOGGER.info("Order updated");
			return order;
			
		
		} else if (reply.equalsIgnoreCase("ADD")) {
			 LOGGER.info("Please enter your order ID");
			 Long orderId1 = utils.getLong();
			 
			 LOGGER.info("Please enter the item ID");
			 Long itemId1 = utils.getLong();
			 Item item = new Item();
			 item.setItemId(itemId1);
			
			 Order order = new Order(orderId1, item);
			 return orderDao.addItem(order);
		} else if (reply.equalsIgnoreCase("REMOVE")) {
			
			LOGGER.info("Please enter the order ID");
			Long orderId = utils.getLong();
			
			LOGGER.info("Please enter the item ID");
			Long itemId = utils.getLong();
			Item item = new Item();
			item.setItemId(itemId);
			
			Order order = new Order(orderId, item);
			return orderDao.deleteItem(order);
		} else if (reply.equalsIgnoreCase("DONE")) {
			
			
			orderDao.readAll();
			
		} else {LOGGER.info("You have entered an incorrect command"); 
			}
		return null;
		
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDao.delete(id);
	}


}
