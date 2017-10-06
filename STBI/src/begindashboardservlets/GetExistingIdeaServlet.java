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

import beginmystartup_pojo.IdeaSubmit;

/**
 * Servlet implementation class GetExistingIdeaServlet
 */
//@WebServlet("/GetExistingIdeaServlet")
public class GetExistingIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rst;
    private ArrayList<IdeaSubmit>arrayideasubmit=null;
    private String ismobile=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetExistingIdeaServlet() {
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
		WebResponse wb;
		arrayideasubmit=new ArrayList<>();
		ismobile=request.getParameter("is_Mobile");
		if(ismobile==null)
		{
			ismobile="0";
		}
		String userid=request.getParameter("userid");
		String getideaquery="select * from ideasubmit where userId=?";
		try {
			pst=connection.prepareStatement(getideaquery);
			pst.setString(1, userid);
			rst=pst.executeQuery();
			IdeaSubmit ideaSubmit=null;
			while(rst.next())
			{
				String ideaid=rst.getString(1);
				String titlename=rst.getString(2);
				String enterkey=rst.getString(3);
				String keyusers=rst.getString(4);
				String maxuser=rst.getString(5);
				String targetmarket=rst.getString(6);
				String ideadiscription=rst.getString(7);
				String attachfile=rst.getString(8);
				String idearegidate=rst.getString(9);
				String statusofidea=rst.getString(10);
				String userId=rst.getString(11);
				String deleteideadescription=rst.getString(11);
				ideaSubmit=new IdeaSubmit(ideaid, titlename, enterkey, keyusers, maxuser, targetmarket, ideadiscription, idearegidate, statusofidea, userId, deleteideadescription);
				arrayideasubmit.add(ideaSubmit);
			}
			
			
			if(ismobile.equals("1"))              //mobile application
			{
				wb=new WebResponse();
				wb.data=arrayideasubmit;
				wb.result=true;
				Gson gson=new Gson();
				String jsondata=gson.toJson(wb);
				pw.write(jsondata);
				
			}
			else										//web application
			{
				request.setAttribute("idealist",arrayideasubmit);
				System.out.println("Data"+request.getAttribute("idealist"));
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
