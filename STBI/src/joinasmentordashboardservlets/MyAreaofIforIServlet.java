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

import joinasmentorpojo.MyAreaofIforI;

/**
 * Servlet implementation class MyAreaofIforIServlet
 */
//@WebServlet("/MyAreaofIforIServlet")
public class MyAreaofIforIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<MyAreaofIforI>arrayList=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAreaofIforIServlet() {
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
		
		
		String skillquery="select mentorskillId,skill from mentorskill where mentorId=?";
		try {
			pst=connection.prepareStatement(skillquery);
			pst.setString(1, mentorId);
			rst=pst.executeQuery();
			
			MyAreaofIforI myAreaofIforI=null;
			while(rst.next())
			{
				String mentorskillid=rst.getString(1);
				String skill=rst.getString(2);
				myAreaofIforI=new MyAreaofIforI(mentorskillid, skill);
				arrayList.add(myAreaofIforI);
				
			}
			
			
			if(ismobile.equals("1"))												//mobile application
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
