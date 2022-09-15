package com.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ems.entity.Address;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
@TestMethodOrder(value=OrderAnnotation.class)
class EmployeeServiceTest {
	EmployeeService	employeeService;
  static List<Employee> emplist;
  
 @BeforeAll
 static void init()
  {
	 emplist=new ArrayList<Employee>();
	 
  }
  @BeforeEach
  void setup() throws Exception {
	   employeeService = new EmployeeService();
	  
  }
  
  @AfterEach
  void tearDown() throws Exception {
	  employeeService=null;
	  System.out.println("object is garbage collected");
  }
@Test
@DisplayName("testing add employee method")
@Order(1)
 public void testAddEmployee()
 {
 employeeService.addEmployee(101, "Nil", 20000, "Kolkata", "India");
 employeeService.addEmployee(102, "Shubajit", 10000, "kolkata", "India");
 assertEquals(2,employeeService.lengthOfList());
	
   //way 2 using builder
// Address add=Address.builder().city("kolkata").country("india").build();
// Employee emp=Employee.builder().empId(101).empName("chandan").build().
//       empSal(10000).address(add).build();
// employeeService.addEmp(emp);
 int length=employeeService.lengthOfList();
 assertThat(length>0).isTrue();
  }
 
@Test
public void testDisplayEmpById() throws GlobalException
   {
	
	employeeService.addEmployee(101, "nilanjan", 20000, "Kolkata", "India");    
	 
 Employee e=employeeService.displayEmpById(101);
    // assertEquals("nilanjan", e.getEmpName());
     assertThat(e.getEmpSal()).isEqualTo(50000));
         
   }
@Test
@DisplayName("testcase for update employee")
@Order(value=3)
public void testUpdateEmp() throws GlobalException
 {
	employeeService.addEmployee(101, "nil", 20000, "kolkata", "india");
	Employee emp=employeeService.findId(101);
	emp.setEmpName("nilanjan");
	
	Employee updateEmp=employeeService.updateEmloyee(0, emp);
	//assertEquals("nilanjan",updateEmp.getEmpName());
	assertThat(UpdateEmp.getEmpName()).isEqualTo("nilanjan");
 }
@Test
@DisplayName("test case for calculate appraisal")
@Order(4)
public void testCalculateAppraisal()
  {
	employeeService.addEmployee(101, "nil", 20000,
			"kolkata", "India");
	double appraisal=employeeService.calculateAppraisalById(101);
	//assertEquals(2000,appraisal);
	assertThat(appraisal).isEqualTo(2000);
  }


@Test
@DisplayName("test case for delete employee")
@Order(2)
public void testDeleteAllEmployee()
  {
	//String msg=employeeService.deleteAllEmployee();
	assertEquals("all employees deleted successfully",
			   employeeService.deleteAllEmployee());
  }


}
