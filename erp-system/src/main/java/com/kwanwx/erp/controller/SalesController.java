package com.kwanwx.erp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kwanwx.erp.model.Sales;
import com.kwanwx.erp.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {
    
    private final SalesService salesService;
    
    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerSales(@RequestBody Sales sales) {
        salesService.registerSales(sales);
        return ResponseEntity.ok("판매 등록이 완료되었습니다.");
    }
    
    @GetMapping("/{salesId}")
    public ResponseEntity<Sales> getSales(@PathVariable String salesId) {
        Sales sales = salesService.getSalesById(salesId);
        if (sales != null) {
            return ResponseEntity.ok(sales);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> salesList = salesService.getAllSales();
        return ResponseEntity.ok(salesList);
    }
}
