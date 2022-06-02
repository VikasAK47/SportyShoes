package com.sportyshoes.controllers.Product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/addProduct")
	public Map<String, String> addProduct(@RequestBody MultiValueMap<String, String> newProductDetails) {
		Map<String, String> addProductresponse = new HashMap<>();
		
	Boolean productAdded = productservice.addProduct( Integer.parseInt(newProductDetails.get("PRODUCT_ID").get(0)), newProductDetails.get("PRODUCT_NAME").get(0),  Integer.parseInt(newProductDetails.get("PRODUCT_MSRP").get(0)),Integer.parseInt(newProductDetails.get("QUANTITY_IN_STOCK").get(0)),newProductDetails.get("PRODUCT_VENDOR").get(0));
		
		if(productAdded) {
			addProductresponse.put("status", "true");
			addProductresponse.put("message", "Product addition success");	
		}else {
			
			addProductresponse.put("status", "false");
			addProductresponse.put("message", "Product addition  not success");	
		}
		return addProductresponse;
	}
	
	@GetMapping("/ProductDetails")
	public String get(Integer PRODUCT_ID) {
		try {
			Product product = this.productservice.getProduct(PRODUCT_ID);
			return product == null ? "Empty set!" : product.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching the record of user #" + PRODUCT_ID + "!\n" + ex);
		}
		
		return null;
	}
	
	@GetMapping("/ProductAllDetails")
	public String getAll() {
		try {
			List<Product> products = this.productservice.getAllProducts();
			
			return products.isEmpty() ? "Empty set!" : products.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching all products records!\n" + ex);
		}
		
		return null;
	}
	
	@GetMapping("/productUpdate")
	public String update(Integer PRODUCT_ID,String PRODUCT_NAME,Integer PRODUCT_MSRP,Integer QUANTITY_IN_STOCK,String  PRODUCT_VENDOR) {
		try {
			if (Boolean.TRUE.equals(this.productservice.updateProduct(PRODUCT_ID, PRODUCT_NAME,PRODUCT_MSRP,QUANTITY_IN_STOCK,PRODUCT_VENDOR))) {
				return String.format("Record of product #%d updated successfully", PRODUCT_ID);
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while updating the record of product #" + PRODUCT_ID + "!\n" + ex);
		}
		
		return String.format("Failure in updating the record of product #%d!", PRODUCT_ID);
	}
	
	
	

}
