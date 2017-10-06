package joinasmentordashboardservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import joinasmentorpojo.MentorPersonalDetails;

/**
 * Servlet implementation class MentorPersonalDetailsServlet
 */
//@WebServlet("/MentorPersonalDetailsServlet")
public class MentorPersonalDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<MentorPersonalDetails>arraylistpd=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorPersonalDetailsServlet() {
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
		
		arraylistpd=new ArrayList<>();
		
		ismobile=request.getParameter("is_Mobile");
		String mid=request.getParameter("mid");
		if(ismobile == null)
		{
			ismobile="0";
		}
		
		String pdquery="select mobilenumber,emailid,tempararyaddress from mentor where mentorId=?";
		try {
			pst=connection.prepareStatement(pdquery);
			pst.setString(1, mid);
			rst=pst.executeQuery();
			MentorPersonalDetails mentorPersonalDetails=null;
			while(rst.next())
			{
				String mn=rst.getString(1);
				String emailid=rst.getString(2);
				String address=rst.getString(3);
				mentorPersonalDetails=new MentorPersonalDetails(mn, emailid, address);
				arraylistpd.add(mentorPersonalDetails);
			}
			
			
			
			if(ismobile.equals("1"))										//mobile application	
			{
				wb.data=arraylistpd;
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
