package com.inatlas.challenge;

public class Product {
    private String name;
    private Integer qtt;
    private boolean discount;
    private String price;

    public Product(String name, Integer qtt, String price) {
        this.name = name;
        this.qtt = qtt;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + getPrice();
    }

    public Integer getQtt() {
        return qtt;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        if (discount) {
            return "$ 0.0";
        }
        
        return price;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}
