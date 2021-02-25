package com.inatlas.challenge.receipt;

import java.util.List;

public interface ReceiptRepo {
	public void addReceipt(Receipt receipt);
	public List<Receipt> findAllReceipts();
}
