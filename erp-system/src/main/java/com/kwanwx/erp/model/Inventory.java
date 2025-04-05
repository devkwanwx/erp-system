package com.kwanwx.erp.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {
	private String inventoryId; // 재고 항목 ID
	private String productName; // 제품 이름
	private String category; // 카테고리
	private int quantity; // 수량
	private BigDecimal unitPrice; // 단가
	private String warehouseLocation; // 창고 위치
	private String supplier; // 공급업체
	private Date lastUpdated; // 최종 수정일
}
