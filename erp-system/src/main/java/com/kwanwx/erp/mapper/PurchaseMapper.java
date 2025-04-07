package com.kwanwx.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kwanwx.erp.model.Purchase;

@Mapper
public interface PurchaseMapper {
	void insertPurchase(Purchase purchase);
	Purchase selectPurchaseById(@Param("purchaseId") String purchaseId);
	List<Purchase> selectAllPurchases();
}