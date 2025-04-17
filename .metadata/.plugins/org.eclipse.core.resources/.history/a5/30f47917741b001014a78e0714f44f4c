package com.kwanwx.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kwanwx.erp.model.Supplier;

@Mapper
public interface SupplierMapper {
	void insertSupplier(Supplier supplier);
	Supplier selectSupplierById(@Param("supplierId") String supplierId);
	List<Supplier> selectAllSuppliers();
}
