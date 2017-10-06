package joinasmentordashboardservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import joinasmentorpojo.MentorBasicDetail;

/**
 * Servlet implementation class MentorBasicServlet
 */
//@WebServlet("/MentorBasicServlet")
public class MentorBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorBasicServlet() {
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
		
		ismobile=request.getParameter("is_Mobile");
		String mid=request.getParameter("mid");
		if(ismobile == null)
		{
			ismobile="0";
		}
		
		String mbasicdquery="select firstname,middlename,lastname,dob,gender,mobilenumber,emailid,adharcardno,tempararyaddress,city,pincode from mentor where mentorId=?";
		try {
			pst=connection.prepareStatement(mbasicdquery);
			pst.setString(1, mid);
			rst=pst.executeQuery();
			
			MentorBasicDetail mentorBasicDetail=null;
			
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
				String tempararyaddress=rst.getString(9);
				String city=rst.getString(10);
				String pincode=rst.getString(11);
				
				mentorBasicDetail=new MentorBasicDetail(firstname, middlename, lastname, dob, gender, contact, emailid, adharcardno, tempararyaddress, city, pincode);
			}
			
																							//mobile application
			if(ismobile.equals("1"))
			{
				wb.data=mentorBasicDetail;
				wb.result=true;
				Gson gson=new Gson();
				String tojson=gson.toJson(wb);
				pw.write(tojson);
			}
			
																							//web application
			
			
			
			
			
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
