package com.inatlas.challenge;

import java.util.Map;

public interface ProductsRepo {
	
	public Map<String, String> getProducts();
	public String getPriceByProduct(String product);
	
}
