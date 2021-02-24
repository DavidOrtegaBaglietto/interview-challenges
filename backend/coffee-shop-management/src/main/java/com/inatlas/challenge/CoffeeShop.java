package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;

import com.inatlas.challenge.receipt.CalculateReceipt;
import com.inatlas.challenge.receipt.Receipt;

public class CoffeeShop {
	
    private List<Product> orders = new ArrayList<>();

    private ProductsRepo productsRepo;    
    private CalculateReceipt calculateReceipt;
    
    public CoffeeShop(ProductsRepo productsRepo, CalculateReceipt calculateReceipt) {
    	this.productsRepo = productsRepo;
    	this.calculateReceipt = calculateReceipt;
    }
    
    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt, productsRepo.getPriceByProduct(product)));
    }

    public void printReceipt() {  
    	calculateReceipt().printReceipt();
    }

    public void printMenu() {
        // Print whole menu
    	System.out.println("| Product Name | Price |");
    	System.out.println("| :---: | :---: |");
    	productsRepo.getProducts().forEach((name, price) -> {
    		System.out.println("| " + name + " | " + price + " |");
    	});
    }
    
    private Receipt calculateReceipt()
    {
    	calculateReceipt.setOrders(orders);
    	return calculateReceipt.calculate();
    }
   
}
