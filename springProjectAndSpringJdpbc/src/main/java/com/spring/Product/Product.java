package com.spring.Product;

import java.util.Date;

public class Product {

	private int  productId;
	
	private String name;
	
	private double price;
	
	private Date addTime;
	
	private int  avaible;

	public Product(int productId, String name, double price, Date addTime, int avaible) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.addTime = addTime;
		this.avaible = avaible;
	}

	public Product() {
			// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getAvaible() {
		return avaible;
	}

	public void setAvaible(int avaible) {
		this.avaible = avaible;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", addTime=" + addTime
				+ ", avaible=" + avaible + "]";
	}
	
	
	
	
	
	
}
