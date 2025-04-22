package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.mapper.PurchaseMapper;
import com.kwanwx.erp.model.Employee;
import com.kwanwx.erp.model.Purchase;

@Service
public class PurchaseService {
	
	private final PurchaseMapper purchaseMapper;
	
	@Autowired
	public PurchaseService(PurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}
	
	public void registerPurchase(Purchase purchase) {
		if (purchase.getPurchaseId() == null || purchase.getPurchaseId().isEmpty()) {
			purchase.setPurchaseId(UUID.randomUUID().toString());
		}
		
		purchaseMapper.insertPurchase(purchase);
	}
	
	public Purchase getPurchaseById(String purchaseId) {
		return purchaseMapper.selectPurchaseById(purchaseId);
	}
	
	public PageInfo<Purchase> getAllPurchases(int page, int size, String sort) {
		PageHelper.startPage(page, size, sort);
		List<Purchase> list = purchaseMapper.selectAllPurchases();
		
		return new PageInfo<>(list);
	}
}
