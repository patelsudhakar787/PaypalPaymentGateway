package begindashboardservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.RepositoryIdHelper;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import beginmystartup_pojo.BasicDetails;
import beginmystartup_pojo.EducationDetails;

/**
 * Servlet implementation class GetBasicDetailsServlet
 */
//@WebServlet("/GetBasicDetailsServlet")
public class GetBasicDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<EducationDetails>arrayedudetails=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBasicDetailsServlet() {
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
		WebResponse wb=new WebResponse();
		
		String ismobile=request.getParameter("is_Mobile");
		
		if(ismobile == null)
		{
			ismobile="0";
		}
		String userid=request.getParameter("userid");
		
		String selectquery="select firstname,middlename,lastname,dob,gender,mobilenumber,emailid,adharcardno,tempararyaddress,permenentaddress,city,pincode from user where userId=?";
	try {
		pst=connection.prepareStatement(selectquery);
		pst.setString(1, userid);
		rst=pst.executeQuery();
		BasicDetails basincdetails=null;
		while(rst.next())
		{
			String firstname=rst.getString(1);
			String middlename=rst.getString(2);
			String lastname=rst.getString(3);
			 String dob=rst.getString(4);
			 String gender=rst.getString(5);
			 String contact=rst.getString(6);
			 String emailid=rst.getString(7);
			 String adharcardno=rst.getString(8);
			 String ta=rst.getString(9);
			 String pa=rst.getString(10);
			 String city=rst.getString(11);
			 String pincode=rst.getString(12);
			 
			 basincdetails=new BasicDetails(firstname, middlename, lastname, dob, gender, contact, emailid, adharcardno,ta, pa, city, pincode);
			
		}
		
		wb.data=basincdetails;
		wb.result=true;
		if(ismobile.equals("1"))
		{
			Gson gson=new Gson();
			String tojson=gson.toJson(wb);
			pw.write(tojson);
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
