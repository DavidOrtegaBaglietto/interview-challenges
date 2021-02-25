package com.inatlas.challenge.receipt;

import java.util.List;

import com.inatlas.challenge.products.Product;

public class GenerateReceiptWithDiscountXPercentAndLatteDiscount extends GenerateReceiptWithDiscountXPercent {
	
	private final Double LATTE_PRICE_WITH_DISCOUNT = 3.0;
	
	public GenerateReceiptWithDiscountXPercentAndLatteDiscount(List<Product> orders, Double discountValue, Integer productsRequiredToApplyDiscount) {			
		super(orders, discountValue, productsRequiredToApplyDiscount);
	}

	@Override
	public Receipt generateReceipt() {		   						  
		orders.forEach(p -> {		
			double price = Double.valueOf(p.getPrice().split("\\$")[1]);
			if (p.getName().equals("Latte")) price = LATTE_PRICE_WITH_DISCOUNT;
			
			receipt.addProduct(p.getName(), price, p.getQtt());
		});
		return receipt;
	}	
}
