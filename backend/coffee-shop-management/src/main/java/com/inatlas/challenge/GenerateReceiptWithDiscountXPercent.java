package com.inatlas.challenge;

import java.util.List;

public class GenerateReceiptWithDiscountXPercent implements GenerateReceipt {

	private List<Product> orders;
	private Receipt receipt;	
	
	public GenerateReceiptWithDiscountXPercent(List<Product> orders, Double discountValue, Integer productsRequiredToApplyDiscount) {		
		this.orders = orders;
		this.receipt = new Receipt(discountValue, productsRequiredToApplyDiscount);
	}

	@Override
	public void generateReceipt() {		   						  
		orders.forEach(p -> {			
			receipt.addProduct(p.getName(), Double.valueOf(p.getPrice().split("\\$")[1]), p.getQtt());
		});
	}
	
	@Override
	public Receipt getReceipt() { 
		return receipt;
	}


}
