package joinasmentordashboardservlets;

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

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import joinasmentorpojo.MentorPersonalExperience;

/**
 * Servlet implementation class MentorPersonalExperienceServlet
 */
//@WebServlet("/MentorPersonalExperienceServlet")
public class MentorPersonalExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<MentorPersonalExperience>arrayList=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorPersonalExperienceServlet() {
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
		arrayList=new ArrayList<>();
		ismobile=request.getParameter("is_Mobile");
		String mentorId=request.getParameter("mid");
		if(ismobile == null)
		{
			ismobile="0";
		}
		
		
		String pexperiencequery="select  mentorexpId,designation,companyname,location,description,fromda,toda from mentorexperience where mentorId=?";
		try {
			pst=connection.prepareStatement(pexperiencequery);
			pst.setString(1, mentorId);
			rst=pst.executeQuery();
			
			MentorPersonalExperience mentorPersonalExperience=null;
			while(rst.next())
			{
				String mentorexpid=rst.getString(1);
				String designation=rst.getString(2);
				String companyname=rst.getString(3);
				String location=rst.getString(4);
				String description=rst.getString(5);
				String fromdate=rst.getString(6);
				String todate=rst.getString(7);
				mentorPersonalExperience=new MentorPersonalExperience(mentorexpid, designation, companyname, location, description, fromdate, todate);
				arrayList.add(mentorPersonalExperience);
			}
			
			if(ismobile.equals("1"))										//mobile application
			{
				wb.data=arrayList;
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
