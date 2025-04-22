package com.kwanwx.erp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kwanwx.erp.dto.ApiResponse;
import com.kwanwx.erp.model.Accounting;
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
    public ResponseEntity<ApiResponse<Sales>> registerSales(@RequestBody Sales sales) {
        salesService.registerSales(sales);

        return ResponseEntity.ok(ApiResponse.of(sales));
    }
    
    @GetMapping("/{salesId}")
    public ResponseEntity<ApiResponse<Sales>> getSales(@PathVariable String salesId) {
        Sales sales = salesService.getSalesById(salesId);

        if (sales != null) {
			return ResponseEntity.ok(ApiResponse.of(sales));
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ApiResponse.error("판매 내역을 찾을 수 없습니다."));
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<Sales>>> getAllSales() {
        List<Sales> salesList = salesService.getAllSales();

        return ResponseEntity.ok(ApiResponse.of(salesList));
    }
}
