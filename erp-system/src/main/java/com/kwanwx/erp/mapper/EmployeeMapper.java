package com.kwanwx.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kwanwx.erp.model.Employee;

@Mapper
public interface EmployeeMapper {
	void insertEmployee(Employee employee);
	Employee selectEmployeeById(@Param("employeeId") String employeeId);
	List<Employee> selectEmployeesByCriteria(@Param("nameFilter") String nameFilter, @Param("departmentFilter") String departmentFilter);
	void updateEmployee(Employee employee);
	void deleteEmployee(@Param("employeeId") String employeeId);
}
