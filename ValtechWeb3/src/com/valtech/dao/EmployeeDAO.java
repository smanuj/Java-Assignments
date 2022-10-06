package com.valtech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

	public static final String TABLE_NAME = "valtemployee";

	public int getNextValidId() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT max(id) from " + TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		int id = -1;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		con.close();
		return id + 1;
	}

	public int count() throws Exception {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select count(id) from " + TABLE_NAME);
		if (rs.next()) {
			int count = rs.getInt(1);
			con.close();
			return count;
		} else {
			con.close();
			return -1;
		}
	}

	public void saveEmployee(Employee e) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT into " + TABLE_NAME + " (id,name,age,gender,salary) values (?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setInt(3, e.getAge());
		ps.setInt(4, e.getGender());
		ps.setDouble(5, e.getSalary());

		int rowsAffected = ps.executeUpdate();
		con.close();

	}

	public int getFirstId(int currId) throws Exception {
		int id = -1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(id) from " + TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			id = rs.getInt(1);
		con.close();
		return id;

	}

	public int getLastId(int currId) throws Exception {
		int id = -1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(id) from " + TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			id = rs.getInt(1);
		con.close();
		return id;

	}

	public int getNextId(int currID) throws Exception {
		int id = -1;
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT id FROM " + TABLE_NAME + " WHERE id > ? FETCH NEXT 1 ROW ONLY");
		ps.setInt(1, currID);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			id = rs.getInt(1);
		conn.close();
		return id;
	}

	public int getPrevId(int currID) throws Exception {
		int id = -1;
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT max(id) FROM " + TABLE_NAME + " WHERE id < ? FETCH NEXT 1 ROW ONLY");
		ps.setInt(1, currID);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			id = rs.getInt(1);
		conn.close();
		return id;

	}

	public Employee getEmployee(int id) throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Employee e = employeeFromResultSet(rs);// refactor and made new private method
			conn.close();
			return e;
		} else {
			return null;
		}

	}

	private Employee employeeFromResultSet(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		// e.setId(id);
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getInt(4));
		e.setSalary(rs.getFloat(5));
		return e;
	}

	public List<Employee> getEmployees() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public void deleteEmployee(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("delete from " + TABLE_NAME + " where id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
	}

	public void updateEmployee(Employee emp) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"Update " + TABLE_NAME + " Set name = ? ,age = ? ,gender = ? ,salary = ?  Where id = ? ");
		// PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " age = ?
		// Where id = ?");
		ps.setInt(5, emp.getId());
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getGender());
		ps.setFloat(4, emp.getSalary());
		ResultSet rs = ps.executeQuery();
		// int affected = ps.executeUpdate();
		con.close();
	}

	public List<Employee> getEmployeesByAge(int age) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where age = " + age);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesBtwAge(int minage, int maxage) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME
				+ " where age between " + minage + " and " + maxage);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesSalGT(float sal) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where salary > " + sal);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesSalGTEQ(float sal) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where salary >=  " + sal);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesSalLT(float sal) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where salary < " + sal);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesSalLTEQ(float sal) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where salary <=  " + sal);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesGenM() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where gender = 1 ");
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesGenF() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where gender = -1 ");
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public List<Employee> getEmployeesGenO() throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("Select id,name,age,gender,salary from " + TABLE_NAME + " where gender = 0 ");
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));

		}
		con.close();
		return employees;
	}

	public Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.35:1521/xe", "valtrg12", "valtrg12");
		// return
		// DriverManager.getConnection("jdbc:mysql:@localhost:3306/xe","username","password");
	}

}
