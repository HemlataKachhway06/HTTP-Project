package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DbOperation;

public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Employee e;
	resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		int v = Integer.parseInt(req.getParameter("id"));
		e = DbOperation.getDataById(v);
		
		pw.print("<form action=\"ConfirmServlet\" method=\"post\">\r\n"
				+ "<input type=\"text\" name=\"id\" value=\""+e.getId()+"\" readonly><br><br>\r\n"
				+ "<input type=\"text\" name=\"name\" value=\""+e.getName()+"\"><br><br>\r\n"
				+ "<input type=\"number\" name=\"salary\" value="+e.getSalary()+"><br><br>\r\n"
				+ "<input type=\"text\" name=\"department\" value="+e.getDepartment()+"><br><br>\r\n"
				+ "<input type=\"number\" name=\"age\" value="+e.getAge()+"><br><br>\r\n"
				+ "<button type=\"submit\">Update</button>\r\n"
				+ "</form>");
	}
}
