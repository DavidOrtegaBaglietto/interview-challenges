package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	private List<String> products;
	private Double totalPrice;
	private Double discountToApplyToTotalPrice;
	private Integer productsRequiredToApplyDiscount;
	private Integer totalProducts;
	
	public Receipt() {		
		this.products = new ArrayList<String>();
		this.totalPrice = 0.0;
		this.discountToApplyToTotalPrice = -1.0;
		this.productsRequiredToApplyDiscount = -1;	
		this.totalProducts = 0;
	}
	
	public Receipt(Double discountToApplyToTotalPrice, Integer productsRequiredToApplyDiscount) {
		this.products = new ArrayList<String>();
		this.totalPrice = 0.0;
		this.discountToApplyToTotalPrice = discountToApplyToTotalPrice;
		this.productsRequiredToApplyDiscount = productsRequiredToApplyDiscount;	
		this.totalProducts = 0;
	}
	
	public void addProduct(String name, Double price, Integer quantity) {		
		products.add(name + " " + "$ " + price * quantity);
		totalPrice += price * quantity;
		totalProducts += quantity;
	}
	
	public Double getTotalPrice() {				
		if (discountToApplyToTotalPrice > 0 				
				&& productsRequiredToApplyDiscount <= totalProducts) 
			return totalPrice - (totalPrice * discountToApplyToTotalPrice);
		else
			return totalPrice;
	}
		
	public void printReceipt() {
        System.out.println("======================================");
        
        products.forEach( p -> {
        	System.out.println(p);
        });
        
        System.out.println("----------------");
        System.out.println("Total: $" + getTotalPrice());
        System.out.println("======================================");
    }
	
	
	
}
