package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;

public interface ProductDao {
	
	// Create Operation
			Integer createProduct(Product product) throws SQLException ;
			
			// Read/Retrieve Operations
			Product findProductById(Integer PRODUCT_ID) throws SQLException ;
			
			List<Product> findAllProducts() throws SQLException ;
			
			// Update Operations
			Integer updateProduct(Product product) throws SQLException ;
			
			
			
			// Delete Operations
			Integer deleteProductById(Integer PRODUCT_ID) throws SQLException;	


}
