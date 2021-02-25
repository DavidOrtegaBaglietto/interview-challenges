package com.inatlas.challenge;

import org.junit.Before;
import org.junit.Test;

import com.inatlas.challenge.client.ClientsRepo;
import com.inatlas.challenge.client.ClientsRepoInMemory;
import com.inatlas.challenge.products.ProductsRepo;
import com.inatlas.challenge.products.ProductsRepoInMemory;
import com.inatlas.challenge.receipt.CalculateCheaperReceipt;
import com.inatlas.challenge.receipt.ReceiptRepo;
import com.inatlas.challenge.receipt.ReceiptRepoInMemory;
import com.inatlas.challenge.reports.GenerateDailyReport;

public class CoffeeShopTest {

	private CoffeeShop coffeeShop;
	
	@Before
	public void setUp() {

		ProductsRepo productsRepo = new ProductsRepoInMemory();
		ClientsRepo clientsRepo =  new ClientsRepoInMemory();
		ReceiptRepo receiptRepo = new ReceiptRepoInMemory();
        coffeeShop = new CoffeeShop(productsRepo, clientsRepo, receiptRepo, new CalculateCheaperReceipt(), new GenerateDailyReport(clientsRepo, receiptRepo));
	}
	
    @Test
    public void testTakeMyFirstOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        
        coffeeShop.addClient(2);
        coffeeShop.takeOrder(2, "Latte", 2);
        coffeeShop.takeOrder(2, "Espresso", 1);
        coffeeShop.takeOrder(2, "Sandwich", 1);
        coffeeShop.printReceipt(2);
        coffeeShop.printDailyReport();
        // Total should be $18.1
    }

    @Test
    public void testTakeMySecondOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 2);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
        // Total should be $15.1
    }

    @Test
    public void testTakeMyThirdOrder3(){
    	
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
        // Total should be $15.1
    }

    @Test
    public void testTakeMyFourthOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 2);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
        // Total should be $18.1
    }
    
    @Test
    public void testTakeMyFifthOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 5);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
    }
    

    @Test
    public void testTakeMySixthOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 10);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 5);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
    }
    
    @Test
    public void testTakeMySeventhOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 6);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
    }
    
    @Test
    public void testTakeMyEighthOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 2);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 4);

        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
    }
    
    @Test
    public void testTakeMyNinethOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
        // Total should be $15.1
    }
    
    @Test
    public void testTakeMyTenthOrder(){
        
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Other", 1);

        coffeeShop.printReceipt(1);
        coffeeShop.printDailyReport();
        // Total should be $15.1
    }
}
