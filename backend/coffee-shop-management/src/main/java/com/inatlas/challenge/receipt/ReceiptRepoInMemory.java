package com.inatlas.challenge.receipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptRepoInMemory implements ReceiptRepo {

	private List<Receipt> receipts = new ArrayList<Receipt>();
		
	@Override
	public void addReceipt(Receipt receipt) {
		receipts.add(receipt);		
	}

	@Override
	public List<Receipt> findAllReceipts() { 
		return receipts;
	}

}
