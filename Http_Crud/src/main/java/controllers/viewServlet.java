package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DbOperation;

public class viewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	
	PrintWriter pw = resp.getWriter();
	pw.print("<table border=\"1\">\r\n"
			+ "<tr>\r\n"
			+ "<th>Id</th>\r\n"
			+ "<th>Name</th>\r\n"
			+ "<th>Salary</th>\r\n"
			+ "<th>Department</th>\r\n"
			+ "<th>Age</th>\r\n"
			+ "<th>Update</th>\r\n"
			+ "<th>Delete</th>\r\n"
			+ "</tr>");
	
	ArrayList<Employee> al = DbOperation.vewData();
	
	for(Employee e : al) {
		pw.print("<tr>\r\n"
				+ "<td>"+e.getId()+"</td>\r\n"
				+ "<td>"+e.getName()+"</td>\r\n"
				+ "<td>"+e.getSalary()+"</td>\r\n"
				+ "<td>"+e.getDepartment()+"</td>\r\n"
				+ "<td>"+e.getAge()+"</td>\r\n"
				+ "\r\n"
				+ "<td>\r\n"
				+ "<form action=\"UpdateServlet\" method=\"post\">\r\n"
				+ "<input type=\"hidden\" name=\"id\" value="+e.getId()+">\r\n"
				+ "<button type=\"submit\">Update</button>\r\n"
				+ "</form>\r\n"
				+ "</td>\r\n"
				+ "\r\n"
				+ "<td>\r\n"
				+ "<form action=\"DeleteServlet\" method=\"post\">\r\n"
				+ "<input type=\"hidden\" name=\"id\" value="+e.getId()+">\r\n"
				+ "<button type=\"submit\">Delete</button>\r\n"
				+ "</form>\r\n"
				+ "</td>\r\n"
				+ "</tr>");
	}	
	pw.print("</table>");
	}
}
