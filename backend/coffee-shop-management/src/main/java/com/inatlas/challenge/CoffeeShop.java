package com.inatlas.challenge;

import com.inatlas.challenge.client.Client;
import com.inatlas.challenge.client.ClientsRepo;
import com.inatlas.challenge.products.Product;
import com.inatlas.challenge.products.ProductsRepo;
import com.inatlas.challenge.receipt.CalculateReceipt;
import com.inatlas.challenge.receipt.Receipt;
import com.inatlas.challenge.receipt.ReceiptRepo;
import com.inatlas.challenge.reports.GenerateReport;

public class CoffeeShop {
	        
    private ProductsRepo productsRepo;    
    private ClientsRepo clientsRepo;    
    private ReceiptRepo receiptRepo;
    private CalculateReceipt calculateReceipt;
    private GenerateReport generateReport; 
    
    public CoffeeShop(ProductsRepo productsRepo, ClientsRepo clientsRepo, ReceiptRepo receiptRepo, CalculateReceipt calculateReceipt, GenerateReport generateReport) {
    	this.productsRepo = productsRepo;
    	this.clientsRepo = clientsRepo;
    	this.receiptRepo = receiptRepo;
    	this.calculateReceipt = calculateReceipt;
    	this.generateReport = generateReport;
    }
    
    public void addClient(Integer clientId)
    {
    	Client client = new Client(clientId);
    	clientsRepo.addClient(client);
    }
    
    public void takeOrder(Integer clientId, String product, Integer qtt) {
    	if (productsRepo.exist(product))
    		clientsRepo.findClientById(clientId).addProductToOrder(new Product(product, qtt, productsRepo.findPriceByProductName(product)));
    	else
    		System.err.println("There is any product called: "+ product);
    }

    public void printReceipt(Integer clientId) {  
    	Receipt receipt = calculateReceipt(clientId);
    	
    	receipt.printReceipt();
    	receiptRepo.addReceipt(receipt);    	    
    }

    public void printMenu() {
        // Print whole menu
    	System.out.println("| Product Name | Price |");
    	System.out.println("| :---: | :---: |");
    	productsRepo.findAllProducts().forEach((name, price) -> {
    		System.out.println("| " + name + " | " + price + " |");
    	});
    }
    
    public void printDailyReport() {
    	generateReport.showReport();
    }
    
    private Receipt calculateReceipt(Integer clienteId) {
    	calculateReceipt.setOrders(clientsRepo.findClientById(clienteId).getOrder());
    	return calculateReceipt.calculate();
    }       
}
