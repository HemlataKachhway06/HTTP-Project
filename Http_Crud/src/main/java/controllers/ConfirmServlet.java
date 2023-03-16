package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DbOperation;

public class ConfirmServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Employee e = new Employee();
	e.setId(Integer.parseInt(req.getParameter("id")));
	e.setName(req.getParameter("name"));
	e.setSalary(Integer.parseInt(req.getParameter("salary")));
	e.setDepartment(req.getParameter("department"));
	e.setAge(Integer.parseInt(req.getParameter("age")));

if(DbOperation.update(e)>0) {
	req.getRequestDispatcher("viewServlet").forward(req, resp);
}
}
}
