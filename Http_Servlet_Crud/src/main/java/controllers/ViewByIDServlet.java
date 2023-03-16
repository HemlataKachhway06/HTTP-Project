package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.DbOperation;

@WebServlet("/ViewByIDServlet")
public class ViewByIDServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
		
		String id = req.getParameter("id");
		User u = DbOperation.getDataById(id);
		
		
		resp.setContentType("text/html");
		
//		pw.print("<meta http-equiv = \"refresh\" content = \"5; url = \"/home.html\"/>");
		pw.print("<table border=\"1\">\r\n"
				+ "<tr>\r\n"
				+ "<th>Id</th>\r\n"
				+ "<th>Name</th>\r\n"
				+ "<th>Age</th>\r\n"
				+ "<th>Contact</th>\r\n"
				+ "<th>City</th>\r\n"
				+ "<th>Travel city</th>\r\n"
				+ "<th>Update</th>\r\n"
				+ "<th>Delete</th>\r\n"
				+ "</tr>");
		
		pw.print("<tr>\r\n"
				+ "<td>"+u.getId()+"</td>\r\n"
				+ "<td>"+u.getName()+"</td>\r\n"
				+ "<td>"+u.getAge()+"</td>\r\n"
				+ "<td>"+u.getContact()+"</td>\r\n"
				+ "<td>"+u.getCity()+"</td>\r\n"
				+ "<td>"+u.getTravel_city()+"</td>\r\n"
				+ "\r\n"
				+ "<td>\r\n"
				+ "<form action=\"UpdateServlet\" method=\"post\">\r\n"
				+ "<input type=\"hidden\" name=\"id\" value="+u.getId()+">\r\n"
				+ "<button type=\"submit\">Update</button>\r\n"
				+ "</form>\r\n"
				+ "</td>\r\n"
				+ "\r\n"
				+ "<td>\r\n"
				+ "<form action=\"DeleteServlet\" method=\"post\">\r\n"
				+ "<input type=\"hidden\" name=\"id\" value="+u.getId()+">\r\n"
				+ "<button type=\"submit\">Delete</button>\r\n"
				+ "</form>\r\n"
				+ "</td>\r\n"
				+ "</tr>");
		
		pw.print("</table>");
		pw.print("<br>");
		pw.print("<form action=\"abcd\">\r\n"
				+ "<input type=\"hidden\" name =\"id\" value = \""+id+"\">\r\n"
				+ "<button type=\"submit\">Reset Password</button>\r\n"
				+ "</form>");
	
	}
}