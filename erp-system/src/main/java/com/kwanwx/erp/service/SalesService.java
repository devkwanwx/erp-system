package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.mapper.SalesMapper;
import com.kwanwx.erp.model.Employee;
import com.kwanwx.erp.model.Sales;

@Service
public class SalesService {
    
    private final SalesMapper salesMapper;
    
    @Autowired
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }
    
    public void registerSales(Sales sales) {
        if (sales.getSalesId() == null || sales.getSalesId().isEmpty()) {
            sales.setSalesId(UUID.randomUUID().toString());
        }
        salesMapper.insertSales(sales);
    }
    
    public Sales getSalesById(String salesId) {
        return salesMapper.selectSalesById(salesId);
    }
    
    public PageInfo<Sales> getAllSales(int page, int size, String sort) {
    	PageHelper.startPage(page, size, sort);
		List<Sales> list = salesMapper.selectAllSales();
		
		return new PageInfo<>(list);
    }
}
