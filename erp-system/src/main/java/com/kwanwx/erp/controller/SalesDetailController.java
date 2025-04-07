package com.kwanwx.erp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kwanwx.erp.model.SalesDetail;
import com.kwanwx.erp.service.SalesDetailService;

@RestController
@RequestMapping("/sales-details")
public class SalesDetailController {
    
    private final SalesDetailService salesDetailService;
    
    @Autowired
    public SalesDetailController(SalesDetailService salesDetailService) {
        this.salesDetailService = salesDetailService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerSalesDetail(@RequestBody SalesDetail salesDetail) {
        salesDetailService.registerSalesDetail(salesDetail);
        return ResponseEntity.ok("판매 상세 등록이 완료되었습니다.");
    }
    
    @GetMapping("/{salesId}")
    public ResponseEntity<List<SalesDetail>> getSalesDetails(@PathVariable String salesId) {
        List<SalesDetail> details = salesDetailService.getSalesDetailsBySalesId(salesId);
        return ResponseEntity.ok(details);
    }
}
