package com.inatlas.challenge;

import java.util.HashMap;
import java.util.Map;

public class ProductsRepoImpl implements ProductsRepo{
	
	@SuppressWarnings("serial")
	private final Map<String, String> products = new HashMap<String, String> ()
			{{
				put("Sandwich", "$ 10.10");
				put("Latte", "$ 5.3");
				put("Espresso", "$ 4");			
				}};

	@Override
	public Map<String, String> getProducts() { 
		return products;
	}

	@Override
	public String getPriceByProduct(String product) {
		
		return products.get(product);
	}

}
