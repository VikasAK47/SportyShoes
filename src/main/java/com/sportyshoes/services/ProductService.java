package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
public Boolean addProduct(Integer PRODUCT_ID,String PRODUCT_NAME,Integer PRODUCT_MSRP,Integer QUANTITY_IN_STOCK,String  PRODUCT_VENDOR)
	{
		
		
		Product product= new Product(PRODUCT_ID,PRODUCT_NAME,PRODUCT_MSRP,QUANTITY_IN_STOCK,PRODUCT_VENDOR);
		
		
		try {
			return productRepository.createProduct(product) > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

public Product getProduct(Integer PRODUCT_ID) throws SQLException {
	
	return this.productRepository.findProductById(PRODUCT_ID) ;
}

public List<Product> getAllProducts() throws SQLException {
	return this.productRepository.findAllProducts();
}

public Boolean updateProduct(Integer PRODUCT_ID,String PRODUCT_NAME,Integer PRODUCT_MSRP,Integer QUANTITY_IN_STOCK,String  PRODUCT_VENDOR) throws SQLException {
	Product product = this.productRepository.findProductById(PRODUCT_ID);
	product.setPRODUCT_NAME(PRODUCT_NAME);
	product.setPRODUCT_MSRP(PRODUCT_MSRP);
	product.setQUANTITY_IN_STOCK(QUANTITY_IN_STOCK);
	
	Integer recordsUpdated = this.productRepository.updateProduct(product);
	
	return recordsUpdated > 0;
}

public Boolean deleteProductById(Integer PRODUCT_ID) throws SQLException {
	Integer recordsDeleted = this.productRepository.deleteProductById(PRODUCT_ID);
	
	return recordsDeleted > 0;
}


	


}
