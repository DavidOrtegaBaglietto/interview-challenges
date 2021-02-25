package com.inatlas.challenge.products;

public class Product implements Cloneable{
    private String name;
    private Integer qtt;
    private boolean discount;
    private String price;

    public Product(String name, Integer qtt, String price) {
        this.name = name;
        this.qtt = qtt;
        this.price = price;
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

	@Override
	public Object clone() throws CloneNotSupportedException  {
		Product clone = null; 
        clone = (Product) super.clone();       
        return clone;
	}
    
}
