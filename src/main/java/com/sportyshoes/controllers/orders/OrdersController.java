package com.sportyshoes.controllers.orders;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;
import com.sportyshoes.services.Ordersservices;

@RestController
@RequestMapping("/api/order")
public class OrdersController {
	@Autowired
	private Ordersservices Orderservices;
	
	@GetMapping("/OrderDetails")
	public String get(Integer PRODUCT_ID) {
		try {
			Product product = this.Orderservices.getAllOrders(PRODUCT_ID);
			return product == null ? "Empty set!" : product.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching the record of user #" + PRODUCT_ID + "!\n" + ex);
		}
		
		return null;
	}
	
	@GetMapping("/ProductAllDetails")
	public String getAll() {
		try {
			List<Product> products = this.Orderservices.getAllOrders();
			
			return products.isEmpty() ? "Empty set!" : products.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching all products records!\n" + ex);
		}
		
		return null;
}
