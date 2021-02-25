package com.inatlas.challenge;

import com.inatlas.challenge.client.Client;
import com.inatlas.challenge.client.ClientsRepo;
import com.inatlas.challenge.receipt.CalculateReceipt;
import com.inatlas.challenge.receipt.Receipt;

public class CoffeeShop {
	        
    private ProductsRepo productsRepo;    
    private ClientsRepo clientsRepo;    
    private CalculateReceipt calculateReceipt;
    
    public CoffeeShop(ProductsRepo productsRepo, ClientsRepo clientsRepo, CalculateReceipt calculateReceipt) {
    	this.productsRepo = productsRepo;
    	this.clientsRepo = clientsRepo;
    	this.calculateReceipt = calculateReceipt;
    }
    
    public void addClient(Integer clientId)
    {
    	Client client = new Client(clientId);
    	clientsRepo.addClient(client);
    }
    
    public void takeOrder(Integer clientId, String product, Integer qtt) {
    	clientsRepo.findClientById(clientId).addProductToOrder(new Product(product, qtt, productsRepo.getPriceByProduct(product)));
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
    	calculateReceipt.setOrders(clientsRepo.findClientById(clienteId).getOrder());
    	return calculateReceipt.calculate();
    }
    

   
}
