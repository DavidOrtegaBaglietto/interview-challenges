package com.inatlas.challenge.client;

import java.util.ArrayList;
import java.util.List;

import com.inatlas.challenge.Product;

public class Client {
	
	private Integer id;
	private List<Product> order;
	
	public Client(Integer id) {
		this.id = id;
		this.order = new ArrayList<Product>(); 
	}
	
	public void addProductToOrder(Product product)
	{
		this.order.add(product);
	}

	public Integer getId() {
		return id;
	}

	public List<Product> getOrder() {
		return order;
	}
	
}
