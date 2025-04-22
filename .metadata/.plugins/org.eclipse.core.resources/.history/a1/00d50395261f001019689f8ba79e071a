package com.kwanwx.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kwanwx.erp.model.Supplier;
import com.kwanwx.erp.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

	private final SupplierService supplierService;
	
	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerSupplier(@RequestBody Supplier supplier) {
		supplierService.registerSupplier(supplier);
		
		return ResponseEntity.ok("공급업체 등록이 완료되었습니다.");
	}
	
	@GetMapping("/{supplierId}")
	public ResponseEntity<Supplier> getSupplier(@PathVariable String supplierId) {
		Supplier supplier = supplierService.getSupplierById(supplierId);
		
		if (supplier != null) {
			return ResponseEntity.ok(supplier);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		
		return ResponseEntity.ok(suppliers);
	}
	
	@PutMapping("/{supplierId}")
    public ResponseEntity<String> updateSupplier(@PathVariable String supplierId, @RequestBody Supplier supplier) {
        supplier.setSupplierId(supplierId);
        supplierService.updateSupplier(supplier);
        
        return ResponseEntity.ok("공급업체 정보가 수정되었습니다.");
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String supplierId) {
        supplierService.deleteSupplier(supplierId);
        
        return ResponseEntity.ok("공급업체가 삭제되었습니다.");
    }
}
