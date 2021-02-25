package com.inatlas.challenge.products;

import java.util.HashMap;
import java.util.Map;

public class ProductsRepoInMemory implements ProductsRepo{
	
	@SuppressWarnings("serial")
	private final Map<String, String> products = new HashMap<String, String> () {{
		put("Sandwich", "$ 10.10");
		put("Latte", "$ 5.3");
		put("Espresso", "$ 4");	
		put("Capuccino", "$ 8");
		put("Tea", "$ 6.1");
		put("Cake Slice", "$ 9");
		put("Milk", "$ 1");	
	}};

	@Override
	public Map<String, String> findAllProducts() { 
		return products;
	}

	@Override
	public String findPriceByProductName(String product) {
		
		return products.get(product);
	}

	@Override
	public Boolean exist(String product) {
		return products.containsKey(product);
	}
}
