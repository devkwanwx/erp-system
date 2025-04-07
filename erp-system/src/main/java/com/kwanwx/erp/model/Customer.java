package com.kwanwx.erp.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private String customerId; // 고객 ID
	private String name;
	private String contact;
	private String email;
	private String address;
	private Date registrationDate;
}
