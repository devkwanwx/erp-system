package com.kwanwx.erp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwanwx.erp.mapper.InventoryMapper;
import com.kwanwx.erp.model.Employee;
import com.kwanwx.erp.model.Inventory;

@Service
public class InventoryService {

	private final InventoryMapper inventoryMapper;
	
	@Autowired
	public InventoryService(InventoryMapper inventoryMapper) {
		this.inventoryMapper = inventoryMapper;
	}
	
	// 재고 등록
	public void registerInventory(Inventory inventory) {
		if (inventory.getInventoryId() == null || inventory.getInventoryId().isEmpty()) {
			inventory.setInventoryId(UUID.randomUUID().toString());
		}
		
		inventoryMapper.insertInventory(inventory);
	} // 등록 시, inventoryId가 없으면 UUID로 생성
	
	// 단일 재고 조회
	public Inventory getInventoryById(String inventoryId) {
		return inventoryMapper.selectInventoryById(inventoryId);
	}
	
	// 전체 재고 조회
	public PageInfo<Inventory> getAlInventories(int page, int size, String sort) {
		PageHelper.startPage(page, size, sort);
		List<Inventory> list = inventoryMapper.selectAllInventories();
		
		return new PageInfo<>(list);
	}
	
	// 재고 정보 수정
	public void updateInventory(Inventory inventory) {
		inventoryMapper.updateInventory(inventory);
	}
	
	// 재고 삭제
	public void deleteInventory(String inventoryId) {
		inventoryMapper.deleteInventory(inventoryId);
	}
}






