package com.ecommerce.catalogs.domain.entity;


import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Order")
public class Order implements Serializable{

	private String orderId; //pk
	private String userId;
	private String name;
	private String productId;
	private int quantity;
	private int unitPrice;
	private int totalPrice;
	private String create_date;
	
	public Order() {
	}

	

	public Order(String orderId, String userId, String name, String productId, int quantity, int unitPrice,
			int totalPrice, String create_date) {
		this.orderId = orderId;
		this.userId = userId;
		this.name = name;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.create_date = create_date;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", name=" + name + ", productId=" + productId
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", create_date=" + create_date + "]";
	}
}
