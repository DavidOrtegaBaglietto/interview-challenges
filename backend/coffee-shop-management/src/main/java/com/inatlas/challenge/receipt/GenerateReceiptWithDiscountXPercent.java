package com.inatlas.challenge.receipt;

import java.util.List;

import com.inatlas.challenge.products.Product;

public class GenerateReceiptWithDiscountXPercent implements GenerateReceipt {

	protected List<Product> orders;
	protected Receipt receipt;	
	
	public GenerateReceiptWithDiscountXPercent(List<Product> orders, Double discountValue, Integer productsRequiredToApplyDiscount) {		
		this.orders = orders;
		this.receipt = new Receipt(discountValue, productsRequiredToApplyDiscount);
	}

	@Override
	public Receipt generateReceipt() {		   						  
		orders.forEach(p -> {			
			receipt.addProduct(p.getName(), Double.valueOf(p.getPrice().split("\\$")[1]), p.getQtt());
		});
		
		return receipt;
	}
}
