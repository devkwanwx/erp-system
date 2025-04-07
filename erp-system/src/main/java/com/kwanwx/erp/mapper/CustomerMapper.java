package com.kwanwx.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kwanwx.erp.model.Customer;

@Mapper
public interface CustomerMapper {
	void insertCustomer(Customer customer);
	Customer selectCustomerById(@Param("customerId") String customerId);
	List<Customer> selectAllCustomers();
}