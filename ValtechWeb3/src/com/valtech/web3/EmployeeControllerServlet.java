package com.valtech.web3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;

@WebServlet(urlPatterns = ("/empCtlr"))
public class EmployeeControllerServlet extends HttpServlet {

	private EmployeeDAO dao;

	@Override
	public void init() {
		dao = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// logic here and forward to jsp page
		try {
			String empid = req.getParameter("empId");
			String submit = req.getParameter("submit");
			if (empid == null) {
				List<Employee> emps = dao.getEmployees();
				req.setAttribute("emps", emps);
				req.getRequestDispatcher("emps.jsp").forward(req, resp);
				return;
			}
			int id = Integer.parseInt(req.getParameter("empId"));
			if("update".equals(submit)) {
                Employee e = dao.getEmployee(id);
                req.setAttribute("e", e);
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                return;
            }
			List<Employee> emps = dao.getEmployees();
			req.setAttribute("emps", emps);
			if("delete".equals(submit)) {
				dao.deleteEmployee(id);
				req.getRequestDispatcher("emps.jsp").forward(req, resp);
				return;
			}
			Employee e = dao.getEmployee(id);
			req.setAttribute("e", e);
			req.getRequestDispatcher("emp.jsp").forward(req, resp);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submit = req.getParameter("submit");
		try {
			if("updateEmp".equals(submit)) {
                //dao=new EmployeeDAO();
                Employee e= new Employee();
                int id = Integer.parseInt(req.getParameter("id"));
                e.setId(id);
                e.setName(req.getParameter("name"));
                e.setAge(Integer.parseInt(req.getParameter("age")));
                e.setGender(Integer.parseInt(req.getParameter("gender")));
                e.setSalary(Float.parseFloat(req.getParameter("salary")));
                dao.updateEmployee(e);
                
            }

			if("New Employee".equals(submit)) {
				req.getRequestDispatcher("CreateEmp.jsp").forward(req, resp);
				return;
			}
			if ("Save".equals(submit)) {
				Employee e = new Employee();
				e.setId(dao.getNextValidId());
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(Integer.parseInt(req.getParameter("gender")));
				e.setSalary(Integer.parseInt(req.getParameter("salary")));
				dao.saveEmployee(e);
			}
			req.setAttribute("emps", dao.getEmployees());
			req.getRequestDispatcher("emps.jsp").forward(req, resp);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

}
