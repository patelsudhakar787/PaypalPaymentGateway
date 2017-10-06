package begindashboardservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import beginmystartup_pojo.PersonalDetails;



/**
 * Servlet implementation class GetPersionalDetails
 */
//@WebServlet("/GetPersionalDetails")
public class GetPersonalDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String fullname="";
	private Calendar calendar=null;
	private int finalage=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPersonalDetailsServlet() {
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
		calendar=Calendar.getInstance();
		String getpersionaldetailquery="emailid,mobilenumber,tempararyaddress from user where userId=?";
		try {
			pst=connection.prepareStatement(getpersionaldetailquery);
			pst.setString(1,userid);
			rst=pst.executeQuery();
			PersonalDetails persionalDetails=null;
			while(rst.next())
			{
			
				String email=rst.getString(1);
				String mobileno=rst.getString(2);
				String address=rst.getString(3);
				persionalDetails=new PersonalDetails(email, mobileno, address);
			}
			
			
			
			if(ismobile.equals("1"))                              //mobile application
			{
				WebResponse wb=new WebResponse();
				wb.data=persionalDetails;
				Gson gson=new Gson();
				String tojson=gson.toJson(wb);
				pw.write(tojson);
			}
			else													//web application
			{
				request.setAttribute("pd",persionalDetails);
				System.out.println("Data"+request.getAttribute("pd"));
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
	
	
	public int findAge(String age)
	{
		String[] year=age.split("/");
		int yer=calendar.get(Calendar.YEAR);
	    int finalag=yer-Integer.parseInt(year[2]);
	    return finalag;
		
		
	}

}
