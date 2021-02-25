package com.inatlas.challenge.reports;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import com.inatlas.challenge.client.ClientsRepo;
import com.inatlas.challenge.products.Product;
import com.inatlas.challenge.receipt.ReceiptRepo;

public class GenerateDailyReport extends GenerateGenericReport {
	
		
	private ClientsRepo clientsRepo;
	private ReceiptRepo receiptRepo;
	
	public GenerateDailyReport(ClientsRepo clientsRepo, ReceiptRepo receiptRepo) {
		this.clientsRepo = clientsRepo;
		this.receiptRepo = receiptRepo;
	}	
	
	@Override
	public void showReport() {
    	System.out.println("| Daily Report |");
    	System.out.println("--------------");
		listAmountOfProductsGroupedByFamily();
		averageClientExpensed();		
	}

	private void listAmountOfProductsGroupedByFamily() {		
    	System.out.println("| List the product sold |");    	
    	System.out.println("| Quantity | Product |");
    	System.out.println("| :---: | :---: |");
		Map<String, Integer> listAmountOfProductsGroupedByFamily = clientsRepo.findAllClients().stream().map(c -> c.getOrder())
				.flatMap(Collection::stream)
				.collect(Collectors.toList())
				.stream().collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getQtt)));
		listAmountOfProductsGroupedByFamily.forEach((family, amount) -> System.out.println("| " + amount + " | " + family + " |"));
		System.out.println("--------------");
		
	}
	
	private void averageClientExpensed() {
		System.out.println("| Average client expense|");
		System.out.println("--------------");
		DoubleSummaryStatistics stats = receiptRepo.findAllReceipts().stream().mapToDouble(x -> x.getTotalPrice()).summaryStatistics();
		System.out.println("$ " + stats.getAverage());
		System.out.println("--------------");
	}
}
