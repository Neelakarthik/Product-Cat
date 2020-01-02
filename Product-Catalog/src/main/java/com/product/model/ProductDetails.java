package com.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class ProductDetails implements Serializable{
	
	private String productType;
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	private String seller;
	
	@Id
	@GeneratedValue
	private long id;
	private String color;
	private char gender;
	private double price;
	private String size;
	
	@ManyToOne()
	@JoinColumn(name="productId")
	private Product product;
	
		
	public long getProductId() {
		return product.getProductId();
	}
	
	
	public String getBrand() {
		return product.getBrand();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	  
	  public void
	  setProduct(Product product) { this.product = product; }
	 

}
