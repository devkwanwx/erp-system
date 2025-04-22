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
import com.kwanwx.erp.model.Accounting;
import com.kwanwx.erp.model.Employee;
import com.kwanwx.erp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 직원 등록 API
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<Employee>> registerEmployee(@RequestBody Employee employee) {
		employeeService.registerEmployee(employee);

		return ResponseEntity.ok(ApiResponse.of(employee));
	}

	// 단일 직원 조회 API
	@GetMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable String employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);

		if (employee != null) {
			return ResponseEntity.ok(ApiResponse.of(employee));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("직원을 찾을 수 없습니다."));
	}

	// 전체 직원 조회 API
	@GetMapping
	public ResponseEntity<ApiResponse<PageInfo<Employee>>> getAllEmployee(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "employee_id") String sort,
			@RequestParam(required = false) String nameFilter,
			@RequestParam(required = false) String departmentFilter) {
		PageInfo<Employee> employees = employeeService.getAllEmployees(page, size, sort, nameFilter, departmentFilter);

		return ResponseEntity.ok(ApiResponse.of(employees));
	}

	// 직원 정보 수정 API
	@PutMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable String employeeId,
			@RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		employeeService.updateEmployee(employee);

		return ResponseEntity.ok(ApiResponse.of(employee));
	}

	// 직원 정보 삭제 API
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable String employeeId) {
		employeeService.deleteEmployee(employeeId);

		return ResponseEntity.ok(ApiResponse.of(null));
	}
}
