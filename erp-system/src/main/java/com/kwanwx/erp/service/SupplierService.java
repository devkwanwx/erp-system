package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.mapper.SupplierMapper;
import com.kwanwx.erp.model.Employee;
import com.kwanwx.erp.model.Supplier;

@Service
public class SupplierService {

	private final SupplierMapper supplierMapper;
	
	@Autowired
	public SupplierService(SupplierMapper supplierMapper) {
		this.supplierMapper = supplierMapper;
	}
	
	public void registerSupplier(Supplier supplier) {
		if (supplier.getSupplierId() == null || supplier.getSupplierId().isEmpty()) {
			supplier.setSupplierId(UUID.randomUUID().toString());
		}
		
		supplierMapper.insertSupplier(supplier);
	}
	
	public Supplier getSupplierById(String supplierId) {
		return supplierMapper.selectSupplierById(supplierId);
	}
	
	public PageInfo<Supplier> getAllSuppliers(int page, int size, String sort) {
		PageHelper.startPage(page, size, sort);
		List<Supplier> list = supplierMapper.selectAllSuppliers();
		
		return new PageInfo<>(list);
	}
	
	public void updateSupplier(Supplier supplier) {
		supplierMapper.updateSupplier(supplier);
	}
	
	public void deleteSupplier(String supplierId) {
		supplierMapper.deleteSupplier(supplierId);
	}
}
