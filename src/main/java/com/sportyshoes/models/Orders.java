package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;

@ApiModel(description ="Details about the Orders")
public class Orders {
	
	Integer PRODUCT_REF_ID;
	Integer ORDER_ID;
	String  ORDER_DATE;
	Integer ORDER_QUANTITY;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer pRODUCT_REF_ID, Integer oRDER_ID, String oRDER_DATE, Integer oRDER_QUANTITY) {
		super();
		PRODUCT_REF_ID = pRODUCT_REF_ID;
		ORDER_ID = oRDER_ID;
		ORDER_DATE = oRDER_DATE;
		ORDER_QUANTITY = oRDER_QUANTITY;
	}

	public Integer getPRODUCT_REF_ID() {
		return PRODUCT_REF_ID;
	}

	public void setPRODUCT_REF_ID(Integer pRODUCT_REF_ID) {
		PRODUCT_REF_ID = pRODUCT_REF_ID;
	}

	public Integer getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(Integer oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public String getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(String oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}

	public Integer getORDER_QUANTITY() {
		return ORDER_QUANTITY;
	}

	public void setORDER_QUANTITY(Integer oRDER_QUANTITY) {
		ORDER_QUANTITY = oRDER_QUANTITY;
	}

	@Override
	public String toString() {
		return "Orders [PRODUCT_REF_ID=" + PRODUCT_REF_ID + ", ORDER_ID=" + ORDER_ID + ", ORDER_DATE=" + ORDER_DATE
				+ ", ORDER_QUANTITY=" + ORDER_QUANTITY + "]";
	}
	
	
	

}
