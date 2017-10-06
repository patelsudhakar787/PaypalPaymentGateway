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

import joinasmentorpojo.LoginAsMentor;

/**
 * Servlet implementation class LoginAsMentorServlet
 */
//@WebServlet("/LoginAsMentorServlet")
public class LoginAsMentorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAsMentorServlet() {
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
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter pw=response.getWriter();
		WebResponse wb=new WebResponse();
		ismobile=request.getParameter("is_Mobile");
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		if(ismobile == null)
		{
			ismobile="0";
		}
		
		String mloginquery="select emailid,password,registrationstatus,mentorId,areaofsupport from mentor where emailid=? and password=?";
		try {
			pst=connection.prepareStatement(mloginquery);
			//setting data to prepared statement
			pst.setString(1, emailid);
			pst.setString(2, password);
			
			rst=pst.executeQuery();
			LoginAsMentor loginAsMentor=null;
			while(rst.next())
			{
				String email=rst.getString(1);
				String pass=rst.getString(2);
				String regisstatus=rst.getString(3);
				
				//checking for email id ,password and registration id
				if(email.equals(emailid) && password.equals(pass) && regisstatus.equals("Approved"))
				{
					String mentorid=rst.getString(4);
					String aofsupport=rst.getString(5);
					loginAsMentor=new LoginAsMentor(emailid, password, regisstatus, mentorid, aofsupport);
				}
			}
			
			
			if(ismobile.equals("0"))					//web appplication
			{
				
			}
			
			
			if(ismobile.equals("1"))					//mobile application
			{
				wb.data=loginAsMentor;
				wb.result=true;
				Gson gson=new Gson();
				String tojson=gson.toJson(wb);
				pw.write(tojson);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
