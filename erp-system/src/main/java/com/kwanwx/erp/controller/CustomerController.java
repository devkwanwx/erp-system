package com.kwanwx.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.dto.ApiResponse;
import com.kwanwx.erp.model.Customer;
import com.kwanwx.erp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<Customer>> registerCustomer(@RequestBody Customer customer) {
		customerService.registerCustomer(customer);
		
		return ResponseEntity.ok(ApiResponse.of(customer));
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<ApiResponse<Customer>> getCustomer(@PathVariable String customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		
		if (customer != null) {
			return ResponseEntity.ok(ApiResponse.of(customer));
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ApiResponse.error("고객을 찾을 수 없습니다."));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponse<PageInfo<Customer>>> getAllCustomers(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "customerId, asc") String sort) {
		PageInfo<Customer> customers = customerService.getAllCustomers(page, size, sort);
		
		return ResponseEntity.ok(ApiResponse.of(customers));
	}
}
