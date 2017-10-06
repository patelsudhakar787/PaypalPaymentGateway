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

import joinasmentorpojo.MentorCourseDesign;

/**
 * Servlet implementation class MentorCourseDesignServlet
 */
//@WebServlet("/MentorCourseDesignServlet")
public class MentorCourseDesignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<MentorCourseDesign>arraylist=null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorCourseDesignServlet() {
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
		String mentorId=request.getParameter("mid");
		
		arraylist=new ArrayList<>();
		if(ismobile == null)
		{
			ismobile="0";
		}
		
		String coursedesignquery="select mentorcourseId,coursename,description,couserlevel,prerequisite,duration,weekmonth,coursecredit,courseobjective,courseoutcomes,coursemodule,coursetool,referencebook from mentorcourse where mentorId=?";
		try {
			pst=connection.prepareStatement(coursedesignquery);
			pst.setString(1, mentorId);
			rst=pst.executeQuery();
			MentorCourseDesign mentorCourseDesign=null;
			while(rst.next())
			{
					String mentorcourseid=rst.getString(1);
					String coursename=rst.getString(2);
					String description=rst.getString(3);
					String couserlevel=rst.getString(4);
					String prerequisite=rst.getString(5);
					String duration=rst.getString(6);
					String weekmonth=rst.getString(7);
					String coursecredit=rst.getString(8);
					String courseobjective=rst.getString(9);
					String courseoutcomes=rst.getString(10);
					String coursemodule=rst.getString(11);
					String coursetool=rst.getString(12);
					String referencebook=rst.getString(13);
					
					mentorCourseDesign=new MentorCourseDesign(mentorcourseid, coursename, description, couserlevel, prerequisite, duration, weekmonth, coursecredit, courseobjective, courseoutcomes, coursemodule, coursetool, referencebook);
					arraylist.add(mentorCourseDesign);
			}
			
			if(ismobile.equals("1"))												//mobile application
			{
				wb.data=arraylist;
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
