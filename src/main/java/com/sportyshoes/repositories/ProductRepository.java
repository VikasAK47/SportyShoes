package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.ProductDao;
import com.sportyshoes.daos.UserDao;
import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class ProductRepository implements ProductDao {
	
	@Autowired
	private DatabaseConnection connection;

	@Override
	public Integer createProduct(Product product) throws SQLException {
		String insertUserFormat = ("INSERT INTO products ( PRODUCT_ID , PRODUCT_NAME , PRODUCT_MSRP,QUANTITY_IN_STOCK,PRODUCT_VENDOR) VALUES(?,?,?,?,?)");
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertUserFormat);) {
			preparedStatement.setInt(1, product.getPRODUCT_ID());
			preparedStatement.setString(2, product.getPRODUCT_NAME());
			preparedStatement.setInt(3, product.getPRODUCT_MSRP());
			preparedStatement.setInt(4, product.getQUANTITY_IN_STOCK());
			preparedStatement.setString(5, product.getPRODUCT_VENDOR());
			
			
			return preparedStatement.executeUpdate();
		} 
	}

	@Override
	public Product findProductById(Integer PRODUCT_ID) throws SQLException {
		String getProductFormat = ("SELECT * FROM products WHERE PRODUCT_ID =? ");

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getProductFormat);) {
			preparedStatement.setInt(1,PRODUCT_ID);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}
			
			Product product =new Product();
			
			while (rs.next()) {
				product.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
				product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
				product.setPRODUCT_MSRP(rs.getInt("PRODUCT_MSRP"));
				product.setQUANTITY_IN_STOCK(rs.getInt("QUANTITY_IN_STOCK"));
				product.setPRODUCT_VENDOR(rs.getString("PRODUCT_VENDOR"));
				
				
				
			}
			return product;
		}
	}

	@Override
	public List<Product> findAllProducts() throws SQLException {
		String getProductFormat = ("SELECT * FROM products");

try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getProductFormat);) {
	ResultSet rs = preparedStatement.executeQuery();
	List<Product> products = new ArrayList<>();

	if (!rs.isBeforeFirst()) {
		return products;
	}

	while (rs.next()) {
		Product product =new Product();
		product.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
		product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
		product.setPRODUCT_MSRP(rs.getInt("PRODUCT_MSRP"));
		product.setQUANTITY_IN_STOCK(rs.getInt("QUANTITY_IN_STOCK"));
		product.setPRODUCT_VENDOR(rs.getString("PRODUCT_VENDOR"));

		products.add(product);
	}

	return products;
}
	}

	@Override
	public Integer updateProduct(Product product) throws SQLException {
		String updateProductFormat = ("UPDATE products SET PRODUCT_ID=?,PRODUCT_NAME=?,PRODUCT_MSRP=?,QUANTITY_IN_STOCK=?,PRODUCT_VENDOR=?");


try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateProductFormat);) {
	preparedStatement.setInt(1, product.getPRODUCT_ID());
	preparedStatement.setString(2, product.getPRODUCT_NAME());
	preparedStatement.setInt(3, product.getPRODUCT_MSRP());
	preparedStatement.setInt(4, product.getQUANTITY_IN_STOCK());
	preparedStatement.setString(5, product.getPRODUCT_VENDOR());
	
	
	return preparedStatement.executeUpdate();
}
	}

	@Override
	public Integer deleteProductById(Integer PRODUCT_ID) throws SQLException {
		String deleteProductFormat = ("DELETE FROM products WHERE PRODUCT_ID=?");

	try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteProductFormat);) {
		preparedStatement.setInt(1, 10);
		return preparedStatement.executeUpdate();
	}



	}
	
	
	
	

}
