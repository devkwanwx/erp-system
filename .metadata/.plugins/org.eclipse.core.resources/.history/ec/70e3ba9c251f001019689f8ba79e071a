package com.kwanwx.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kwanwx.erp.model.Purchase;
import com.kwanwx.erp.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

	private final PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerPurchase(@RequestBody Purchase purchase) {
		purchaseService.registerPurchase(purchase);
		
		return ResponseEntity.ok("구매 등록이 완료되었습니다.");
	}
	
	@GetMapping("/{purchaseId}")
	public ResponseEntity<Purchase> getPurchase(@PathVariable String purchaseId) {
		Purchase purchase = purchaseService.getPurchaseById(purchaseId);
		
		if (purchase != null) {
			return ResponseEntity.ok(purchase);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Purchase>> getAllPurchases() {
		List<Purchase> purchases = purchaseService.getAllPurchases();
		
		return ResponseEntity.ok(purchases);
	}
}
