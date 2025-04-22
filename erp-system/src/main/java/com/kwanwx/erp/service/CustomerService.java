package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.mapper.CustomerMapper;
import com.kwanwx.erp.model.Customer;
import com.kwanwx.erp.model.Employee;

@Service
public class CustomerService {

	private final CustomerMapper customerMapper;
	
	@Autowired
	public CustomerService(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	
	public void registerCustomer(Customer customer) {
		if (customer.getCustomerId() == null || customer.getCustomerId().isEmpty()) { 
			customer.setCustomerId(UUID.randomUUID().toString());
		}
		
		customerMapper.insertCustomer(customer);
	}
	
	public Customer getCustomerById(String customerId) {
		return customerMapper.selectCustomerById(customerId);
	}
	
	public PageInfo<Customer> getAllCustomers(int page, int size, String sort) {
		PageHelper.startPage(page, size, sort);
		List<Customer> list = customerMapper.selectAllCustomers();
		
		return new PageInfo<>(list);
	}
}
