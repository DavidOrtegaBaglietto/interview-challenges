package com.inatlas.challenge.receipt;

import java.util.ArrayList;
import java.util.List;

import com.inatlas.challenge.products.Product;

public class CalculateCheaperReceipt extends CalculateReceiptGeneric {
	
	private final Double PROMOTION_WHEN_ORDER_VALUE_OVER = 50.0;
	

	@Override
	public Receipt calculate() {
		GenerateReceipt generateReceiptWithPromotionFreeEspresso = new GenerateReceiptWithPromotionFreeEspresso(cloneProductsList(orders));
    	GenerateReceipt generateReceiptWithDiscountXPercent = new GenerateReceiptWithDiscountXPercent(cloneProductsList(orders), 0.05, 8);
    	    	
    	return compareAndGetTheCheapestReceipt(
    			generateReceiptWithPromotionFreeEspresso.generateReceipt(),
    			generateReceiptWithDiscountXPercent.generateReceipt());
    	    	
	}
	
	private Receipt compareAndGetTheCheapestReceipt(Receipt receiptWithPromotionFreeEspresso, Receipt receiptWithDiscountXPercent) {
		if (receiptWithPromotionFreeEspresso.getTotalPrice() > receiptWithDiscountXPercent.getTotalPrice()) {	    		
    		if (receiptWithDiscountXPercent.getTotalPrice() < PROMOTION_WHEN_ORDER_VALUE_OVER) return receiptWithDiscountXPercent;
    		else {
    			GenerateReceipt generateReceiptWithDiscountXPercentAndLatteDiscount = new GenerateReceiptWithDiscountXPercentAndLatteDiscount(cloneProductsList(orders), 0.05, 8);
    			return generateReceiptWithDiscountXPercentAndLatteDiscount.generateReceipt();    			
    		}    		    	
		}
    	else {	    		
    		if (receiptWithPromotionFreeEspresso.getTotalPrice() < PROMOTION_WHEN_ORDER_VALUE_OVER) return receiptWithPromotionFreeEspresso;
    		else {
    			GenerateReceipt generateReceiptWithPromotionFreeEspressoAndLatteDiscount = new GenerateReceiptWithPromotionFreeEspressoAndLatteDiscount(cloneProductsList(orders));
    			return generateReceiptWithPromotionFreeEspressoAndLatteDiscount.generateReceipt();    			
    		}  
    	}
	}
	
	public List<Product> cloneProductsList(List<Product> list) {
        List<Product> clone = new ArrayList<Product>(list.size());
        for (Product item : list) {
			try {
				clone.add((Product) item.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
        }
        
        return clone;
	}
}
