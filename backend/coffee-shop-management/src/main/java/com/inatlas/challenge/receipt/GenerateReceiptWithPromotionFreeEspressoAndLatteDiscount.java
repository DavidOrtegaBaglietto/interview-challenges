package com.inatlas.challenge.receipt;

import java.util.List;

import com.inatlas.challenge.Product;

public class GenerateReceiptWithPromotionFreeEspressoAndLatteDiscount extends GenerateReceiptWithPromotionFreeEspresso {

	private final Double LATTE_PRICE_WITH_DISCOUNT = 3.0;
	
	public GenerateReceiptWithPromotionFreeEspressoAndLatteDiscount(List<Product> orders) {
		super(orders);		
	}
	
	@Override
	public Receipt generateReceipt() {		   
		updateIfThereAreDiscountToApply(); 
				   
		orders.forEach(p -> {	
			double price = Double.valueOf(p.getPrice().split("\\$")[1]);
			if (p.getName().equals("Latte")) price = LATTE_PRICE_WITH_DISCOUNT;
			
			receipt.addProduct(p.getName(), price, p.getQtt());
		});
		
		return receipt;
	}
		

}
