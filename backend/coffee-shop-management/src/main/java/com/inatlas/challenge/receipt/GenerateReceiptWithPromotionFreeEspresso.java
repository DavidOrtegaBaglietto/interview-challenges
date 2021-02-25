package com.inatlas.challenge.receipt;

import java.util.List;
import java.util.stream.Collectors;

import com.inatlas.challenge.products.Product;

public class GenerateReceiptWithPromotionFreeEspresso implements GenerateReceipt {

	private final int DISCOUNT_WHEN_BUY_X_LATTES= 2;
	protected List<Product> orders;
	protected Receipt receipt;
	
	public GenerateReceiptWithPromotionFreeEspresso(List<Product> orders) {
		this.orders = orders;
		this.receipt = new Receipt();
	}
	
	@Override
	public Receipt generateReceipt() {		   
		updateIfThereAreDiscountToApply(); 
				   
		orders.forEach(p -> {			
			receipt.addProduct(p.getName(), Double.valueOf(p.getPrice().split("\\$")[1]), p.getQtt());
		});
		
		return receipt;
	}
	
	protected void updateIfThereAreDiscountToApply() {
		
		int totalFreeExpresso = calculateTotalFreeExpressos();
		
		if (totalFreeExpresso == 0) return;
				        
		for (Product p : getOnlyEspressoProducts()) {
			if (totalFreeExpresso == 0) break;
          		           
            p.setDiscount(true);
            totalFreeExpresso--;          		
		}
	}
	
	private int calculateTotalFreeExpressos() {        
        int totalLates = (int) this.orders.stream().filter(p -> p.getName().equals("Latte")).map(p -> {        	
        	return p.getQtt();
        }).reduce(0, (a,b) -> a + b);
                
        if (totalLates > 1) return totalLates / DISCOUNT_WHEN_BUY_X_LATTES;
        
        return 0;
	}
	
	private List<Product> getOnlyEspressoProducts() {
		return this.orders.stream().filter(p -> p.getName().equals("Espresso")).collect(Collectors.toList());
	}

}
