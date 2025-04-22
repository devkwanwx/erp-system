package com.kwanwx.erp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kwanwx.erp.dto.ApiResponse;
import com.kwanwx.erp.model.Accounting;
import com.kwanwx.erp.model.PurchaseDetail;
import com.kwanwx.erp.service.PurchaseDetailService;

@RestController
@RequestMapping("/purchase-details")
public class PurchaseDetailController {
    
    private final PurchaseDetailService purchaseDetailService;
    
    @Autowired
    public PurchaseDetailController(PurchaseDetailService purchaseDetailService) {
        this.purchaseDetailService = purchaseDetailService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<PurchaseDetail>> registerPurchaseDetail(@RequestBody PurchaseDetail purchaseDetail) {
        purchaseDetailService.registerPurchaseDetail(purchaseDetail);

        return ResponseEntity.ok(ApiResponse.of(purchaseDetail));
    }
    
    @GetMapping("/{purchaseId}")
    public ResponseEntity<ApiResponse<List<PurchaseDetail>>> getPurchaseDetails(@PathVariable String purchaseId) {
        List<PurchaseDetail> details = purchaseDetailService.getPurchaseDetailsByPurchaseId(purchaseId);
        
        return ResponseEntity.ok(ApiResponse.of(details));
    }
}
