package com.kwanwx.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.dto.ApiResponse;
import com.kwanwx.erp.mapper.InventoryMapper;
import com.kwanwx.erp.model.Accounting;
import com.kwanwx.erp.model.Inventory;
import com.kwanwx.erp.service.InventoryService;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

	private final InventoryService inventoryService;
	
	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	// 재고 등록
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<Inventory>> registerInventory(@RequestBody Inventory inventory) {
		inventoryService.registerInventory(inventory);
		
		return ResponseEntity.ok(ApiResponse.of(inventory));
	}
	
	// 단일 재고 조회
	@GetMapping("/{inventoryId}")
	public ResponseEntity<ApiResponse<Inventory>> getInventory(@PathVariable String inventoryId) {
		Inventory inventory = inventoryService.getInventoryById(inventoryId);
		
		if (inventory != null) {
			return ResponseEntity.ok(ApiResponse.of(inventory));
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ApiResponse.error("재고를 찾을 수 없습니다."));
	}
	
	//전체 재고 조회
	@GetMapping
	public ResponseEntity<ApiResponse<PageInfo<Inventory>>> getAllInventories(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "inventoryId, asc") String sort) {
		PageInfo<Inventory> inventories = inventoryService.getAlInventories(page, size, sort);
		
		return ResponseEntity.ok(ApiResponse.of(inventories));
	}
	
	// 재고 정보 수정
	@PutMapping("/{inventoryId}")
	public ResponseEntity<ApiResponse<Inventory>> updateInventory(@PathVariable String inventoryId, @RequestBody Inventory inventory) {
		inventory.setInventoryId(inventoryId);
		inventoryService.updateInventory(inventory);
		
		return ResponseEntity.ok(ApiResponse.of(inventory));
	}
	
	// 재고 삭제
	@DeleteMapping("/{inventoryId}")
	public ResponseEntity<ApiResponse<Void>> deleteInventory(@PathVariable String inventoryId) {
		inventoryService.deleteInventory(inventoryId);
		
		return ResponseEntity.ok(ApiResponse.of(null));
	}
}





