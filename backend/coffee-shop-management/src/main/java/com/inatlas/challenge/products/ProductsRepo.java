package com.inatlas.challenge.products;

import java.util.Map;

public interface ProductsRepo {
	
	public Map<String, String> findAllProducts();
	public Boolean exist(String product);
	public String findPriceByProductName(String product);
	
}
