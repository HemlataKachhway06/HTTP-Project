package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbOperation;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String v = req.getParameter("id");
	
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	
			
		if(!DbOperation.delete(v)) {
			pw.print("<meta http-equiv = \"refresh\" content = \"3; url = \"/home.html\"/>");
//			resp.getWriter().print("Delete successful");
			//req.getRequestDispatcher("home.html").include(req, resp);
			
			resp.sendRedirect("home.html");
		}
		else {
			resp.getWriter().print("Data could not deleted !");
		}
	}
}
