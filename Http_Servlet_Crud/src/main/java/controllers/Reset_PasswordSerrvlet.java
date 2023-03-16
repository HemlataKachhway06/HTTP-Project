package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbOperation;
@WebServlet("/Reset_PasswordSerrvlet")
public class Reset_PasswordSerrvlet extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("id");
		String oldpass = req.getParameter("oldpass");
		String newpass = req.getParameter("newpass");
		String confirmpass = req.getParameter("confirmpass");
		
		if(!DbOperation.login(id,oldpass) && newpass.equals(confirmpass)) {
			DbOperation.resetPassword(id, confirmpass);
			resp.sendRedirect("Login.html");
		}
	}
}