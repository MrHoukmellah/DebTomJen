package com.TPJEE.JDBCORMSingleton.WEB.model;

import java.util.List;

import com.TPJEE.JDBCORMSingleton.BO.entities.Product;

public class ProductModel {

	private List<Product> products;
	private String keyWord;
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(List<Product> products, String keyWord) {
		super();
		this.products = products;
		this.keyWord = keyWord;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
}
