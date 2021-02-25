package com.inatlas.challenge;

import java.util.HashMap;
import java.util.Map;

import com.inatlas.challenge.client.Client;
import com.inatlas.challenge.receipt.CalculateReceipt;
import com.inatlas.challenge.receipt.Receipt;

public class CoffeeShop {
	    
    private Map<Integer, Client> clients = new HashMap<Integer, Client>();

    private ProductsRepo productsRepo;    
    private CalculateReceipt calculateReceipt;
    
    public CoffeeShop(ProductsRepo productsRepo, CalculateReceipt calculateReceipt) {
    	this.productsRepo = productsRepo;
    	this.calculateReceipt = calculateReceipt;
    }
    
    public void addClient(Integer clientId)
    {
    	clients.put(clientId, new Client(clientId));
    }
    
    public void takeOrder(Integer clientId, String product, Integer qtt) {
        clients.get(clientId).addProductToOrder(new Product(product, qtt, productsRepo.getPriceByProduct(product)));
    }

    public void printReceipt(Integer clientId) {  
    	Receipt receipt = calculateReceipt(clientId);
    	
    	receipt.printReceipt();
    	
    }

    public void printMenu() {
        // Print whole menu
    	System.out.println("| Product Name | Price |");
    	System.out.println("| :---: | :---: |");
    	productsRepo.getProducts().forEach((name, price) -> {
    		System.out.println("| " + name + " | " + price + " |");
    	});
    }
    
    private Receipt calculateReceipt(Integer clienteId)
    {
    	calculateReceipt.setOrders(clients.get(clienteId).getOrder());
    	return calculateReceipt.calculate();
    }
   
}
