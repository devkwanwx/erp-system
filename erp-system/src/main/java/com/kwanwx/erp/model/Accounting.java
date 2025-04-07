package com.kwanwx.erp.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Accounting {
	private String transactionId; // 거래 ID (PK)
	private Date transactionDate; // 거래일자
	private String employeeId; // 직원 ID (FK)
	private String departmentId; // 부서 ID (FK)
	private BigDecimal amount; // 거래 금액
	private String transactionType; // 거래 유형
	private String description; // 거래 설명
}
