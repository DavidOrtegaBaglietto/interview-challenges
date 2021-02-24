package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	private final int DISCOUNT_WHEN_BUY_X_LATTES= 2;
    private List<Product> orders = new ArrayList<>();

    private ProductsRepo productsRepo;
    
    public CoffeeShop(ProductsRepo productsRepo)
    {
    	this.productsRepo = productsRepo;
    }
    
    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt, productsRepo.getPriceByProduct(product)));
    }

    public void printReceipt() {
        System.out.println("======================================");
        
        int totalFreeExpresso = 0;
        
        int totalLates = (int) this.orders.stream().filter(p -> p.getName().equals("Latte")).map(p -> {        	
        	return p.getQtt();
        }).reduce(0, (a,b) -> a + b);
        
        
        if (totalLates > 1) totalFreeExpresso = totalLates / DISCOUNT_WHEN_BUY_X_LATTES;
               
        for (Product p : this.orders)
        {
          	if (totalFreeExpresso == 0) break;
          	else
          	{
	            if (p.getName().equals("Espresso")) {
	                p.setDiscount(true);
	                totalFreeExpresso--;
	            }
          	}
        }
      
        
        Double total = this.orders.stream().map(p -> {
            System.out.println(p);
            return Double.valueOf(p.getPrice().split("\\$")[1]);
        }).reduce(0.0, (a, b) -> a + b);
        System.out.println("----------------");
        System.out.println("Total: $" + total);
        System.out.println("======================================");
    }

    public void printMenu() {
        // Print whole menu
    	System.out.println("| Product Name | Price |");
    	System.out.println("| :---: | :---: |");
    	productsRepo.getProducts().forEach((name, price) -> {
    		System.out.println("| " + name + " | " + price + " |");
    	});
    }
}
