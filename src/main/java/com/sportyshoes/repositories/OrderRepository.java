package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.OrdersDao;
import com.sportyshoes.models.Orders;
import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class OrderRepository implements OrdersDao {
	@Autowired
	private DatabaseConnection connection;

	

	@Override
	public Order findOrderById(Integer PRODUCT_REF_ID) throws SQLException {
		String getOrderFormat = ("SELECT * FROM orders WHERE USER_ID =? ");

try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrderFormat);) {
	preparedStatement.setInt(1,PRODUCT_REF_ID);
	ResultSet rs = preparedStatement.executeQuery();

	if (!rs.isBeforeFirst()) {
		return null;
	}

	Orders orders = new Orders();
	while (rs.next()) {
		orders.setPRODUCT_REF_ID(rs.getInt("PRODUCT_REF_ID"));
		orders.setORDER_ID(rs.getInt("ORDER_ID"));
		orders.setORDER_DATE(rs.getString("ORDER_DATE"));
		orders.setORDER_QUANTITY(rs.getInt("ORDER_QUANTITY"));
		
	
		
	}
	return orders;
}
	}

	@Override
	public List<Order> findAllOrders() throws SQLException {
		String getOrderFormat = ("SELECT * FROM orders");

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrderFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Orders order = new Orders();
				
				order.setPRODUCT_REF_ID(rs.getInt("PRODUCT_REF_ID"));
				order.setORDER_ID(rs.getInt("ORDER_ID"));
				order.setORDER_DATE(rs.getString("ORDER_DATE"));
				order.setORDER_QUANTITY(rs.getInt("ORDER_QUANTITY"));
				
			}

			return order;
		}
	}
	
	
}
