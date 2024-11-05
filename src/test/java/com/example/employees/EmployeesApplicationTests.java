package com.example.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static com.example.employees.EmployeeServies.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeesApplicationTests {

	@Mock
	private EmployeeServies employeeServies;

	@InjectMocks
	private DepartmentServies departmentServies;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	private Employee[] employees(){
		Employee[] employees = {
				new Employee("Иван", "Иванов", (byte) 1, 50000),
				new Employee("Дмитрий", "Александров", (byte) 4, 15000),
				new Employee("Евгений", "Александров", (byte) 4, 55500)
		};
        return employees;
    }

	@Test
	public void groupEmployeesByDepartmentTest() {


		when(employeeServies.getEmployees()).thenReturn(employees);

		Map<Byte, List<Employee>> result = departmentServies.groupEmployeesByDepartment((byte) 4);
		assertEquals(1, result.size());
		assertEquals(2, result.get((byte) 4).size());
	}

	@Test
	public void getMinSalaryTest() {

		when(employeeServies.getEmployees()).thenReturn(employees);

		List<String> result = departmentServies.getMinSalary((byte) 4);
		assertEquals(1, result.size());
		assertEquals("Employee{name='Дмитрий', familyName='Александров', fullName='Александров Дмитрий', departament=4, salary=15000}", result.get(0));
	}


}
