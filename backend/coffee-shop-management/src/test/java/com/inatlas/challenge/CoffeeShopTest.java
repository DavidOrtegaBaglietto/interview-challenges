package com.inatlas.challenge;

import org.junit.Test;

import com.inatlas.challenge.receipt.CalculateCheaperReceipt;

public class CoffeeShopTest {
    
    @Test
    public void testTakeMyFirstOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        // Total should be $18.1
    }

    @Test
    public void testTakeMySecondOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 2);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        // Total should be $15.1
    }

    @Test
    public void testTakeMyThirdOrder3(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        // Total should be $15.1
    }

    @Test
    public void testTakeMyFourthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 2);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 1);
        coffeeShop.printReceipt();
        // Total should be $18.1
    }
    
    @Test
    public void testTakeMyFifthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 5);
        coffeeShop.printReceipt();
    }
    

    @Test
    public void testTakeMySixthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 10);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 5);
        coffeeShop.printReceipt();
    }
    
    @Test
    public void testTakeMySeventhOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 6);
        coffeeShop.printReceipt();
    }
    
    @Test
    public void testTakeMyEighthOrder(){
        CoffeeShop coffeeShop = new CoffeeShop(new ProductsRepoImpl(), new CalculateCheaperReceipt());
        coffeeShop.printMenu();
        coffeeShop.takeOrder("Latte", 2);
        coffeeShop.takeOrder("Espresso", 1);
        coffeeShop.takeOrder("Sandwich", 4);

        coffeeShop.printReceipt();
    }
}
