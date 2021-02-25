package com.inatlas.challenge;

import org.junit.Test;

import com.inatlas.challenge.client.ClientsRepoInMemory;
import com.inatlas.challenge.receipt.CalculateCheaperReceipt;

public class CoffeeShopTest {
    
    @Test
    public void testTakeMyFirstOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
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
        // Total should be $18.1
    }

    @Test
    public void testTakeMySecondOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 2);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        // Total should be $15.1
    }

    @Test
    public void testTakeMyThirdOrder3(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        // Total should be $15.1
    }

    @Test
    public void testTakeMyFourthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 2);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 1);
        coffeeShop.printReceipt(1);
        // Total should be $18.1
    }
    
    @Test
    public void testTakeMyFifthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 5);
        coffeeShop.printReceipt(1);
    }
    

    @Test
    public void testTakeMySixthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 10);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 5);
        coffeeShop.printReceipt(1);
    }
    
    @Test
    public void testTakeMySeventhOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 6);
        coffeeShop.printReceipt(1);
    }
    
    @Test
    public void testTakeMyEighthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoInMemory(), new ClientsRepoInMemory(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.addClient(1);
        coffeeShop.takeOrder(1, "Latte", 2);
        coffeeShop.takeOrder(1, "Espresso", 1);
        coffeeShop.takeOrder(1, "Sandwich", 4);

        coffeeShop.printReceipt(1);
    }
}
