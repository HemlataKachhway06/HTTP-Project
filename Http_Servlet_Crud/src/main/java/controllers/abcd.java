package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
@WebServlet("/abcd")
public class abcd  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			resp.getWriter().print("<form action=\"Reset_PasswordSerrvlet\">\r\n"
					+ "<input type=\"hidden\" name=\"id\" value=\""+req.getParameter("id")+"\"><br><br>\r\n"
					+ "Old Password<input type=\"password\" name=\"oldpass\"><br><br>\r\n"
					+ "New Password<input type=\"password\" name=\"newpass\"><br><br>\r\n"
					+ "Confirm Password<input type=\"password\" name=\"confirmpass\"><br><br>\r\n"
					+ "<button type=\"submit\">Submit</button>\r\n"
					+ "</form>\r\n"
					+ "<a href=\" \"><button>Go to Login</button></a>");
	}
}
