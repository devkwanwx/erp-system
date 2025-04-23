package com.kwanwx.erp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.UUID;

import com.kwanwx.erp.mapper.EmployeeMapper;
import com.kwanwx.erp.model.Employee;

public class EmployeeServiceTest {

	@Mock
	private EmployeeMapper employeeMapper;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void registerEmployee_shouldGenerateUuid_whenIdIsNull() {
		// given
		Employee e = new Employee();
		e.setEmployeeId(null);
		e.setName("홍길동");
		// when
		employeeService.registerEmployee(e);
		// then
		assertThat(e.getEmployeeId())
			.isNotNull()
			.matches(id -> {
				// UUID 형식인지 검사
				try {
					UUID.fromString(id);
					return true;
				} catch (Exception ex) {
					return false;
				}
			});
		verify(employeeMapper).insertEmployee(e);
	}
	
	@Test
	void registerEmployee_shouldKeepId_whenAlreadyPresent() {
		// given
		Employee e = new Employee();
		e.setEmployeeId("fixed-id-123");
		// when
		employeeService.registerEmployee(e);
		//then
		assertThat(e.getEmployeeId()).isEqualTo("fixed-id-123");
		verify(employeeMapper).insertEmployee(e);
	}
	
	@Test
	void getEmployeeById_shouldReturnFromMapper() {
		// given
		Employee mock = new Employee();
		mock.setEmployeeId("id1");
		when(employeeMapper.selectEmployeeById("id1")).thenReturn(mock);
		// when
		Employee found = employeeService.getEmployeeById("id1");
		// then
		assertThat(found).isSameAs(mock);
	}
}









