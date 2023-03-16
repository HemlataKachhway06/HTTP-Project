package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.DbOperation;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User u = new User();
		
    u.setId(req.getParameter("id"));
    u.setPassword(req.getParameter("password")); 
    u.setName(req.getParameter("name"));
    u.setAge(Integer.parseInt(req.getParameter("age")));
	u.setContact(req.getParameter("contact"));
	u.setCity(req.getParameter("city"));
	u.setTravel_city(req.getParameter("travel_city"));
			
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	
	if(!DbOperation.register(u)) {
		//pw.print("<h1>"+"Registration Successfull.."+"</h1>");
		req.getRequestDispatcher("home.html").forward(req, resp);
	}
	else {
		pw.print("<h1>"+"Registration failed !"+"</h1>");
		req.getRequestDispatcher("Register.html").include(req, resp);
	}
	}
}
