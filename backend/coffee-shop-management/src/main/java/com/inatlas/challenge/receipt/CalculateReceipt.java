package com.inatlas.challenge.receipt;

import java.util.List;

import com.inatlas.challenge.products.Product;

public interface CalculateReceipt {
		
	public void setOrders(List<Product> orders);
	public Receipt calculate();
	
}
