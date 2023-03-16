package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.DbOperation;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pass = req.getParameter("password");
		boolean r = DbOperation.login(id, pass);
		resp.setContentType("text/html");		
		PrintWriter pw = resp.getWriter();
		if(!r)
		{
	           
//			resp.setContentType("text/html");
//
//			PrintWriter pw = resp.getWriter();
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

			ArrayList<User> al = DbOperation.vewData();

			for(User u : al) {
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
			}	
			pw.print("</table>");
			}
			
//			
//			pw.print("<form action=\"UpdateServlet\">\r\n"
//			+ "<input type=\"hidden\" name = \"id\" value = "+id+">\r\n"
//				+ "<button type=\"submit\">Update</button>\r\n"
//				+ "</form>\r\n"
//				+ "");
//		
//		pw.print("<form action=\"DeleteServlet\">\r\n"
//				+ "<input type=\"hidden\" name = \"id\" value = "+id+">\r\n"
//				+ "<button type=\"submit\">Delete</button>\r\n"
//				+ "</form>\r\n"
//				+ "");
//		pw.print("<a href=\"home.html\"><button>HOME</button></a>");
		
		else
		{
			pw.print("<h2>Invalid username or password.</h2>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
	}