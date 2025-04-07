package com.kwanwx.erp.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sales {
	private String salesId; // 판매 ID
	private String customerId; // 고객 ID (FK)
	private Date salesDate;
	private BigDecimal totalAmount;
}
