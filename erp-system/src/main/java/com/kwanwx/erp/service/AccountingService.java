package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwanwx.erp.mapper.AccountingMapper;
import com.kwanwx.erp.model.Accounting;

@Service
public class AccountingService {

	private final AccountingMapper accountingMapper;
	
	@Autowired
	public AccountingService(AccountingMapper accountingMapper) {
		this.accountingMapper = accountingMapper;
	}
	
	// 회계 거래 등록
	public void registerAccounting(Accounting accounting) {
		if (accounting.getTransactionId() == null || accounting.getTransactionId().isEmpty()) {
			accounting.setTransactionId(UUID.randomUUID().toString());
		}
		
		accountingMapper.insertAccounting(accounting);
	}
	
	// 단일 회계 거래 조회
	public Accounting getAccountingById(String transactionId) {
		return accountingMapper.selectAccountingById(transactionId);
	}
	
	// 전체 회계 거래 조회
	public List<Accounting> getAllAccountings() {
		return accountingMapper.selectAllAccountings();
	}
	
	// 회계 거래 수정
	public void updateAccounting(Accounting accounting) {
		accountingMapper.updateAccounting(accounting);
	}
	
	// 회계 거래 삭제
	public void deleteAccounting(String transactionId) {
		accountingMapper.deleteAccounting(transactionId);
	}
}
