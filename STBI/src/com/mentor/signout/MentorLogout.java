package com.mentor.signout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MentorLogout
 */
//@WebServlet("/MentorLogout")
public class MentorLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			try
				{
				HttpSession session;
				session=request.getSession();
				session.invalidate();
				out.println("<html><body style=background-color:#FFFFFF>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('You Logout Successfully')");
				out.println("document.location.href = 'mentor-login.jsp';\n");
				out.println("</script>");
				out.println("</body></html>");
				response.sendRedirect("mentor-login.jsp");
				}
			catch(Exception e)
			{
				out.println(e);
			}
		}
	}
