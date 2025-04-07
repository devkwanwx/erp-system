package com.kwanwx.erp.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDetail {
	private String purchaseId; // 구매 ID (FK)
	private String inventoryId; // 재고 항목 ID (FK)
	private int quantity;
	private BigDecimal price;
}
