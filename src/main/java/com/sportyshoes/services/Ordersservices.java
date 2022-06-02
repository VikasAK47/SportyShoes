package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.OrderRepository;

@Service
public class Ordersservices {
	@Autowired
	private OrderRepository orderRepository;
	
public User getUser(Integer PRODUCT_REF_ID) throws SQLException {
		
		return this.orderRepository.findOrderById(PRODUCT_REF_ID) ;
	}
	
	public List<Order> getAllOrders() throws SQLException {
		return this.orderRepository.findAllOrders();
	}
	

}
