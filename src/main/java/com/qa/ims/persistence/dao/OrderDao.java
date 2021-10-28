package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDao implements Dao<Order> {


	public static final Logger LOGGER = LogManager.getLogger();
	
	
	

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		
		Long orderId = resultSet.getLong("ordersId");
		
		Long customerId = resultSet.getLong("customerId");
		String fname = resultSet.getString("firstName");
		String sname = resultSet.getString("surname");
		Customer customer = new Customer(customerId, fname, sname);
		
		Long itemId = resultSet.getLong("itemId");
		String itemName = resultSet.getString("itemName");
		Double price = resultSet.getDouble("price");
		Item item = new Item(itemId, itemName, price);
		
		Long itemQuantity = resultSet.getLong("itemQuantity");
		Double total = resultSet.getDouble("total");
		return new Order(orderId, customer, itemQuantity, total, item);
		
		
	}
	
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelFromResultSet(resultSet));
			}
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders WHERE orderId = ?");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}

	@Override
	public Order create(Order t) {
		
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customerId) VALUES (?)");) {
			statement.setLong(1, t.getCustomer().getId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET itemQuantity = ?, total = ? WHERE ordersId = ?;");) {
			statement.setLong(1, t.getItemQuantity());
			statement.setDouble(2, t.getTotal());
			statement.setLong(3, t.getOrdersId());
			statement.executeUpdate();
			return read(t.getOrdersId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order addItem(Order t) {
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(ordersId, itemId) VALUES (?, ?)");) {
			statement.setLong(1, t.getOrdersId());
			statement.setLong(2, t.getItem().getItemId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order deleteItem(Order u) {
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM orders_items WHERE ordersId = ? AND itemId = ?;");) {
			statement.setLong(1, u.getOrdersId());
			statement.setLong(2, u.getItem().getItemId());
			statement.executeUpdate();
			return null;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}
	
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE orderId = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

}
