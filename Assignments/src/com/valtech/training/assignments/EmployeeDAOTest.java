package com.valtech.training.assignments;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class EmployeeDAOTest {

	@Test
	public void test() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Connection conn = dao.getConnection();
		conn.close();
	}

	// @Test
	// public void testCount()throws Exception {
	// EmployeeDAO dao=new EmployeeDAO();
	// assertEquals(11, dao.count());
	// }

	// @Test
	// public void testSaveEmployee()throws Exception {
	// EmployeeDAO dao=new EmployeeDAO();
	// int count=dao.count();
	// dao.saveEmployee(new Employee(108,"raju",25,1,10000));
	// assertEquals(count+1, dao.count());
	// dao.deleteEmployee(108);
	// assertEquals(count, dao.count());
	//
	// }

//	@Test
//	public void testGetEmployee() throws Exception {
//		EmployeeDAO dao = new EmployeeDAO();
//		Employee e = dao.getEmployee(101);
//		assertEquals(101, e.getId());
//		assertEquals(21, e.getAge());
//	}

	@Test
	public void testGetEmployees() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(dao.count(), dao.getEmployees().size());
	}

	// @Test
	// public void testDeleteEmployee()throws Exception {
	// EmployeeDAO dao=new EmployeeDAO();
	// dao.deleteEmployee(id);
	// int count=dao.count();
	// assertEquals(count, dao.count());
	// }
	//

	// @Test
	// public void testupdate() throws Exception {
	// EmployeeDAO dao = new EmployeeDAO();
	// Employee e=dao.getEmployee(105);
	// dao.updateEmployee(e);
	// assertEquals(21, e.getAge());
	//
	//
	// }

	@Test
	public void testupdateEmployee() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		dao.updateEmployee(new Employee(105, "rajuu", 12, 1, 12121));
		Employee e = dao.getEmployee(105);
		assertEquals(e.getId(), 105);
		assertEquals(e.getName(), "rajuu");
		assertEquals(12, e.getAge());
		assertEquals(1, e.getGender());
		assertEquals(12121, e.getSalary(), 0.000001);

	}

	@Test
	public void testGetEmployeesByAge() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(2, dao.getEmployeesByAge(21).size());
	}

	@Test
	public void testGetEmployeesBtwAge() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(3, dao.getEmployeesBtwAge(21, 22).size());
	}

	@Test
	public void testGetEmployeesSalGT() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(4, dao.getEmployeesSalGT(5000).size());
	}

	@Test
	public void testGetEmployeesSalGTEQ() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(4, dao.getEmployeesSalGTEQ(5000).size());
	}

	@Test
	public void testGetEmployeesSalLT() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(1, dao.getEmployeesSalLT(5000).size());
	}

	@Test
	public void testGetEmployeesSalLTEQ() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(1, dao.getEmployeesSalLTEQ(5000).size());
	}

	@Test
	public void testGetEmployeesGenM() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(3, dao.getEmployeesGenM().size());
	}

	@Test
	public void testGetEmployeesGenF() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(1, dao.getEmployeesGenF().size());
	}

	@Test
	public void testGetEmployeesGenO() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		assertEquals(0, dao.getEmployeesGenO().size());
	}

}
