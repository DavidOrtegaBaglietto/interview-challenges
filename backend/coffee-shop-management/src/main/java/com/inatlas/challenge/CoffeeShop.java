package com.inatlas.challenge;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	
    private List<Product> orders = new ArrayList<>();

    private ProductsRepo productsRepo;    
    
    public CoffeeShop(ProductsRepo productsRepo) {
    	this.productsRepo = productsRepo;
    }
    
    public void takeOrder(String product, Integer qtt) {
        this.orders.add(new Product(product, qtt, productsRepo.getPriceByProduct(product)));
    }

    public void printReceipt() {    	    
    	getCheapestReceipt().printReceipt();
    }

    public void printMenu() {
        // Print whole menu
    	System.out.println("| Product Name | Price |");
    	System.out.println("| :---: | :---: |");
    	productsRepo.getProducts().forEach((name, price) -> {
    		System.out.println("| " + name + " | " + price + " |");
    	});
    }
    
    private Receipt getCheapestReceipt() {
    	GenerateReceipt generateReceiptWithPromotionFreeEspresso = new GenerateReceiptWithPromotionFreeEspresso(cloneProductsList(orders));
    	GenerateReceipt generateReceiptWithDiscountFivePercent = new GenerateReceiptWithDiscountXPercent(cloneProductsList(orders), 0.05, 8);
    	
    	generateReceiptWithPromotionFreeEspresso.generateReceipt();
    	generateReceiptWithDiscountFivePercent.generateReceipt();
    
    	if (generateReceiptWithPromotionFreeEspresso.getReceipt().getTotalPrice() > generateReceiptWithDiscountFivePercent.getReceipt().getTotalPrice()) 
    		return generateReceiptWithDiscountFivePercent.getReceipt();
    	else 
    		return generateReceiptWithPromotionFreeEspresso.getReceipt();
    }
    
    public List<Product> cloneProductsList(List<Product> list) {
        List<Product> clone = new ArrayList<Product>(list.size());
        for (Product item : list)
			try {
				clone.add((Product) item.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return clone;
    }
}
