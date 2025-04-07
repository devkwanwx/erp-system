package com.kwanwx.erp.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Purchase {
	private String purchaseId; // 구매 ID
	private String supplierId; // 공급업체 ID (FK)
	private Date purchaseDate;
	private BigDecimal totalAmount;
}
