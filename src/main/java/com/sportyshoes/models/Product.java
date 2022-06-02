package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="Details about the Products")
public class Product {
	@ApiModelProperty(notes = "Unique Product ID")
	Integer  PRODUCT_ID;
	@ApiModelProperty(notes = "Unique Product Name")
	String PRODUCT_NAME;
	@ApiModelProperty(notes = "Unique Product Price")
	Integer PRODUCT_MSRP;
	@ApiModelProperty(notes = "Unique Product Stocks")
	Integer QUANTITY_IN_STOCK;
	@ApiModelProperty(notes = "Unique Vendor")
	String PRODUCT_VENDOR;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer pRODUCT_ID, String pRODUCT_NAME, Integer pRODUCT_MSRP, Integer qUANTITY_IN_STOCK,
			String pRODUCT_VENDOR) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		PRODUCT_MSRP = pRODUCT_MSRP;
		QUANTITY_IN_STOCK = qUANTITY_IN_STOCK;
		PRODUCT_VENDOR = pRODUCT_VENDOR;
	}

	public Integer getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(Integer pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public Integer getPRODUCT_MSRP() {
		return PRODUCT_MSRP;
	}

	public void setPRODUCT_MSRP(Integer pRODUCT_MSRP) {
		PRODUCT_MSRP = pRODUCT_MSRP;
	}

	public Integer getQUANTITY_IN_STOCK() {
		return QUANTITY_IN_STOCK;
	}

	public void setQUANTITY_IN_STOCK(Integer qUANTITY_IN_STOCK) {
		QUANTITY_IN_STOCK = qUANTITY_IN_STOCK;
	}

	public String getPRODUCT_VENDOR() {
		return PRODUCT_VENDOR;
	}

	public void setPRODUCT_VENDOR(String pRODUCT_VENDOR) {
		PRODUCT_VENDOR = pRODUCT_VENDOR;
	}

	@Override
	public String toString() {
		return "Products [PRODUCT_ID=" + PRODUCT_ID + ", PRODUCT_NAME=" + PRODUCT_NAME + ", PRODUCT_MSRP="
				+ PRODUCT_MSRP + ", QUANTITY_IN_STOCK=" + QUANTITY_IN_STOCK + ", PRODUCT_VENDOR=" + PRODUCT_VENDOR
				+ "]";
	}
	
	

}
