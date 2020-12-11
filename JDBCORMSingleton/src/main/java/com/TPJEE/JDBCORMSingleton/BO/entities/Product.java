package com.TPJEE.JDBCORMSingleton.BO.entities;

import java.io.Serializable;


//Classes that do not implement this interface will not have any of their state serialized or deserialized. 
/*All subtypes of a serializable class are themselves serializable. The serialization interface has no methods or fields and serves
 *only to identify the semantics of being serializable.
 *
 */

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String designation;
	private double price;
	private int quantity;
	


	@Override
	public String toString() {
		return "Product [id=" + id + ", designation=" + designation + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String designation, double price, int quantity) {
		super();
		this.id = id;
		this.designation = designation;
		this.price = price;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
