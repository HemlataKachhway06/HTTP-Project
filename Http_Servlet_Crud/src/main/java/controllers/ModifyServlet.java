package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import dao.DbOperation;

public class ModifyServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User u = new User();
		u.setId(req.getParameter("id"));
		u.setName(req.getParameter("name"));
		u.setAge(Integer.parseInt(req.getParameter("age")));
		u.setContact(req.getParameter("contact"));
		u.setCity(req.getParameter("city"));
		u.setTravel_city(req.getParameter("travel_city"));

	if(DbOperation.update(u)>0) {
		req.getRequestDispatcher("ViewByIDServlet").include(req, resp);
	}
	else
	{
		System.out.println("not updated");
	}
}
}