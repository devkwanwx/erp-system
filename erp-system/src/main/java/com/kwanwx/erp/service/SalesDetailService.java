package com.kwanwx.erp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kwanwx.erp.mapper.SalesDetailMapper;
import com.kwanwx.erp.model.SalesDetail;

@Service
public class SalesDetailService {
    
    private final SalesDetailMapper salesDetailMapper;
    
    @Autowired
    public SalesDetailService(SalesDetailMapper salesDetailMapper) {
        this.salesDetailMapper = salesDetailMapper;
    }
    
    public void registerSalesDetail(SalesDetail salesDetail) {
        salesDetailMapper.insertSalesDetail(salesDetail);
    }
    
    public List<SalesDetail> getSalesDetailsBySalesId(String salesId) {
        return salesDetailMapper.selectSalesDetailsBySalesId(salesId);
    }
}
