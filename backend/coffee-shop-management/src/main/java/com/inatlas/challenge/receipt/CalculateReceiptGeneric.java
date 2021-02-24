package com.inatlas.challenge.receipt;

import java.util.List;

import com.inatlas.challenge.Product;

public abstract class CalculateReceiptGeneric implements CalculateReceipt{

	protected List<Product> orders;
	
	@Override
	public void setOrders(List<Product> orders) {
		this.orders = orders;		
	}

	@Override
	public abstract Receipt calculate();
	
}
