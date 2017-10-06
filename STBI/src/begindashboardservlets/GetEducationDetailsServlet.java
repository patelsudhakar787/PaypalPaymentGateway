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

import beginmystartup_pojo.EducationDetails;

/**
 * Servlet implementation class GetEducationDetailsServlet
 */
//@WebServlet("/GetEducationDetailsServlet")
public class GetEducationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rst;
    private ArrayList<EducationDetails>arrayedudetails=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEducationDetailsServlet() {
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
	arrayedudetails=new ArrayList<>();
	
	String ismobile=request.getParameter("is_Mobile");
	String userid=request.getParameter("userid");
	String edudetailsurl="select * from education where userId=?";
	try {
		pst=connection.prepareStatement(edudetailsurl);
		pst.setString(1, userid);
		rst=pst.executeQuery();
		EducationDetails educationDetails=null;
		while(rst.next())
		{
			String eduid=rst.getString(1);
			String collegename=rst.getString(2);
			String qualification=rst.getString(3);
			String stream=rst.getString(4);
			String grade=rst.getString(5);
			String fdate=rst.getString(6);
			String tdate=rst.getString(7);
			String description=rst.getString(8);
			String uid=rst.getString(9);
			educationDetails=new EducationDetails(eduid, collegename, qualification, stream, grade, fdate, tdate, description, uid);
			arrayedudetails.add(educationDetails);
		}
		
		
																				//mobile application
		if(ismobile.equals("1"))
		{
			WebResponse wb=new WebResponse();
			wb.data=arrayedudetails;
			Gson gson=new Gson();
			String tojson=gson.toJson(wb);
			pw.write(tojson);
		}
		else																	//web application
		{
			request.setAttribute("ed",arrayedudetails);
			System.out.println("Data"+request.getAttribute("ed"));
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
