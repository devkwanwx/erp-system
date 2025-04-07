package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kwanwx.erp.mapper.SalesMapper;
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
    
    public List<Sales> getAllSales() {
        return salesMapper.selectAllSales();
    }
}
