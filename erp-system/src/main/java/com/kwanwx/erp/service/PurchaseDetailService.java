package com.kwanwx.erp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kwanwx.erp.mapper.PurchaseDetailMapper;
import com.kwanwx.erp.model.PurchaseDetail;

@Service
public class PurchaseDetailService {
    
    private final PurchaseDetailMapper purchaseDetailMapper;
    
    @Autowired
    public PurchaseDetailService(PurchaseDetailMapper purchaseDetailMapper) {
        this.purchaseDetailMapper = purchaseDetailMapper;
    }
    
    public void registerPurchaseDetail(PurchaseDetail purchaseDetail) {
        purchaseDetailMapper.insertPurchaseDetail(purchaseDetail);
    }
    
    public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(String purchaseId) {
        return purchaseDetailMapper.selectPurchaseDetailsByPurchaseId(purchaseId);
    }
}
