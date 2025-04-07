package com.kwanwx.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kwanwx.erp.model.Accounting;

@Mapper
public interface AccountingMapper {
	void insertAccounting(Accounting accounting);
	Accounting selectAccountingById(@Param("transactionId") String transactionId);
	List<Accounting> selectAllAccountings();
	void updateAccounting(Accounting accounting);
	void deleteAccounting(@Param("transactionId") String transactionId);
}
