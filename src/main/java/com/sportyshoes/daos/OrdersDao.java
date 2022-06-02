package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.core.annotation.Order;



public interface OrdersDao {
	
	
	
	// Read/Retrieve Operations
	Order findOrderById(Integer  PRODUCT_REF_ID) throws SQLException ;
	
	List<Order> findAllOrders() throws SQLException ;
	
	

}
