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
import com.mentor.mentorpersonalinfo.MentorAddEducation;

import joinasmentorpojo.MentorEducation;

/**
 * Servlet implementation class MentorEducationServlet
 */
//@WebServlet("/MentorEducationServlet")
public class MentorEducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<MentorEducation>arraylistmedu=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorEducationServlet() {
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
		
		arraylistmedu=new ArrayList<>();
		ismobile=request.getParameter("is_Mobile");
		if(ismobile == null)
		{
			ismobile="0";
		}
		
		String mentorid=request.getParameter("mid");
		String mentoreduquery="select * from mentoreducation where mentorId=?";
		try {
			pst=connection.prepareStatement(mentoreduquery);
			pst.setString(1, mentorid);
			rst=pst.executeQuery();
			
			MentorEducation mentorEducation=null;
			
			
			while(rst.next())
			{
				int mentoreid=rst.getInt(1);
				String cname=rst.getString(2);
				String qln=rst.getString(3);
				String srm=rst.getString(4);
				String gdr=rst.getString(5);
				String fd=rst.getString(6);
				String td=rst.getString(7);
				String des=rst.getString(8);
				int mid=rst.getInt(9);
				mentorEducation=new MentorEducation(mentoreid, cname, qln, srm, gdr, fd, td, des, mid);
				
				arraylistmedu.add(mentorEducation);
			}
			
			
			
			if(ismobile.equals("1"))										//mobile application
			{	
				wb.data=arraylistmedu;
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
