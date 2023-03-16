package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import dao.DbOperation;

public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User e;
	resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String v = req.getParameter("id");
		e = DbOperation.getDataById(v);
		
		pw.print("<form action=\"ModifyServlet\" method=\"post\">\r\n"
				+ "<input type=\"text\" name=\"id\" value=\""+e.getId()+"\" readonly required><br><br>\r\n"
				+ "<input type=\"text\" name=\"name\" value=\""+e.getName()+"\" required><br><br>\r\n"
			    + "<input type=\"number\" name=\"age\" value="+e.getAge()+" required><br><br>\r\n"
				+ "<input type=\"text\" name=\"contact\" value="+e.getContact()+" required><br><br>\r\n"
				+ "<input type=\"text\" name=\"city\" value="+e.getCity()+" required><br><br>\r\n"
				+ "<input type=\"text\" name=\"travel_city\" value="+e.getTravel_city()+" required><br><br>\r\n"
				+ "<button type=\"submit\">Update</button>\r\n"
				+ "</form>");
	}
}