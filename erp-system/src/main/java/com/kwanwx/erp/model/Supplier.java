package com.kwanwx.erp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Supplier {
	private String supplierId; // 공급업체 ID
	private String name;
	private String contact;
	private String email;
	private String address;	
	private String description;	
}
