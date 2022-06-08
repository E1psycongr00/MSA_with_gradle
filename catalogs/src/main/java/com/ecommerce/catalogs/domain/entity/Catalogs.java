package com.ecommerce.catalogs.domain.entity;

import org.apache.ibatis.type.Alias;

@Alias("Catalogs")
public class Catalogs {

	private String productId;
	private String productName;
	private int stock;
	private int price;
	private String createDate;
	
	public Catalogs() {
	}

	public Catalogs(String productId, String productName, int stock, int price, String createDate) {
		this.productId = productId;
		this.productName = productName;
		this.stock = stock;
		this.price = price;
		this.createDate = createDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Catalog [productId=" + productId + ", productName=" + productName + ", stock=" + stock + ", price="
				+ price + ", createDate=" + createDate + "]";
	}
}

