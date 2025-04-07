package com.kwanwx.erp.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesDetail {
	private String salesId; // 판매 ID (FK)
	private String inventoryId; // 재고 항목 ID (FK)
	private int quantity;
	private BigDecimal price;
}
