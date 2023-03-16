package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DbOperation;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Employee e = new Employee();
		e.setId(Integer.parseInt(req.getParameter("id")));
		e.setName(req.getParameter("name"));
		e.setSalary(Integer.parseInt(req.getParameter("salary")));
		e.setDepartment(req.getParameter("department"));
		e.setAge(Integer.parseInt(req.getParameter("age")));
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		if(!DbOperation.insert(e)) {
			pw.print("<h1>"+"Registration succesfull..."+"</h1>");
			req.getRequestDispatcher("home.html").forward(req, resp);
		}
		else {
			pw.print("<h1>"+"Registration failed !"+"</h1>");
			req.getRequestDispatcher("Register.html").include(req, resp);
		}
	}
}
