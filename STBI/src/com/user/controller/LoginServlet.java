package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private boolean flag=false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		
		try {
			connection=Dao.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		WebResponse wb;
		String userid="";
		String ismobile=request.getParameter("is_Mobile");
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println("email"+emailid);
		System.out.println("password"+password);
		System.out.println("ismobile"+ismobile);
		String loginquery="Select emailid,password,userId from user where emailid=? and password=?";
		try {
			pst=connection.prepareStatement(loginquery);
			pst.setString(1,emailid);
			pst.setString(2, password);
			rst=pst.executeQuery();
			
			while(rst.next())
			{
			String eid=rst.getString(1);
			String pwd=rst.getString(2);
			if(eid.equals(emailid) && pwd.equals(password))
			{
			userid=rst.getString(3);
			flag=true;
			break;
			}
			else{
				flag=false;
			}
			}
			
			if(ismobile.equals("1"))
			{
				wb=new WebResponse();
				if(flag == true)
				{
				wb.data=userid;
				wb.result=true;
				}
				if(flag == false)
				{
					wb.data="No Data";
					wb.result=false;
				}
				Gson gson=new Gson();
				String toJson=gson.toJson(wb);
				pw.write(toJson);
				
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("useremail",emailid);
				RequestDispatcher rd=request.getRequestDispatcher("/Table.jsp");
	        	rd.forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
