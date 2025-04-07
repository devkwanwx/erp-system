package com.kwanwx.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kwanwx.erp.model.Sales;

@Mapper
public interface SalesMapper {
	void insertSales(Sales sales);
	Sales selectSalesById(@Param("salesId") String salesId);
	List<Sales> selectAllSales();
}