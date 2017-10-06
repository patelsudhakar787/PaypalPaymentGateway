package begindashboardservlets;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import beginmystartup_pojo.Skills;

/**
 * Servlet implementation class GetSkilDetailsServlet
 */
//@WebServlet("/GetSkilDetailsServlet")
public class GetSkilDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private ArrayList<Skills>arrayskills;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSkilDetailsServlet() {
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
		
		PrintWriter pw=response.getWriter();
		
		String ismobile=request.getParameter("is_Mobile");
		String userid=request.getParameter("userid");
		arrayskills=new ArrayList<>();
		String myskillurl="select * from skills where userId=?";
		try {
			pst=connection.prepareStatement(myskillurl);
			pst.setString(1,userid);
			rst=pst.executeQuery();
			Skills skills=null;
			while(rst.next())
			{
				String skillid=rst.getString(1);
				String skillname=rst.getString(2);
				String uid=rst.getString(3);
				skills=new Skills(skillid, skillname, uid);
				arrayskills.add(skills);
			}
			
			
			if(ismobile.equals("1"))													//mobile application
			{
				WebResponse wb=new WebResponse();
				wb.data=arrayskills;
				wb.result=true;
				Gson gson=new Gson();
				String tojson=gson.toJson(wb);
				pw.write(tojson);
			}															
			else																			//web application	
			{
				request.setAttribute("skilllist",arrayskills);
				System.out.println("Data"+request.getAttribute("skilllist"));
				RequestDispatcher rd=request.getRequestDispatcher("/begin-dashboard.jsp");
	        	rd.forward(request,response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
