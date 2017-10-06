package begindashboardservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.dao.WebResponse;
import com.google.gson.Gson;

import beginmystartup_pojo.BasicDetails;
import beginmystartup_pojo.EducationDetails;
import beginmystartup_pojo.IdeaSubmit;
import beginmystartup_pojo.PersonalDetails;
import beginmystartup_pojo.Skills;
import beginmystartup_pojo.WebIdeaSubmit;

/**
 * Servlet implementation class BeginDashBoardServlet
 */
@WebServlet("/BeginDashBoardServlet")
public class BeginDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rst;
	private String ismobile=null;
	private ArrayList<EducationDetails>arrayedudetails=null;
	private ArrayList<IdeaSubmit>arrayideasubmit=null;
	private String fullname="";
	private Calendar calendar=null;
	private int finalage=0;
	private ArrayList<Skills>arrayskills=null;
	private String module=null;
	private BasicDetails basincdetails=null;
	private PersonalDetails persionalDetails=null;
	private String userid=null;
	private String fname="";
	private long uid=0;
	private ArrayList<WebIdeaSubmit>arraywebidea=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeginDashBoardServlet() {
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
		if(module == null)
		{
			module="web";
		}
		if(module.equals("0"))
		{
			HttpSession httpSession=request.getSession();
			String useremail=(String) httpSession.getAttribute("useremail");
			
			String useridquery="select firstname,middlename,lastname userId from user where emailid=?";
			try {
				pst=connection.prepareStatement(useridquery);
				rst=pst.executeQuery();
				while(rst.next())
				{
				userid=rst.getString(1);
				String firstname=rst.getString(2);
				String middlename=rst.getString(3);
				String latname=rst.getString(4);
				fname=firstname+" "+middlename+" "+latname;
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
		if(ismobile.equals("1"))
		{
		userid=request.getParameter("userid");
		}
		String module=request.getParameter("module");
		
		
		
		//code for getting basic details
		if(module.equals("basicdetails") || module.equals("web"))
		{
			String selectquery="select firstname,middlename,lastname,dob,gender,mobilenumber,emailid,adharcardno,tempararyaddress,permenentaddress,city,pincode from user where userId=?";
			try {
				pst=connection.prepareStatement(selectquery);
				pst.setString(1, userid);
				rst=pst.executeQuery();
				
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
		
		//code for getting education details
		if(module.equals("educationdetails") || module.equals("web"))
		{
		arrayedudetails=new ArrayList<>();
		
		
		String edudetailsurl="select * from education where userId=?";
		try {
			pst=connection.prepareStatement(edudetailsurl);
			pst.setString(1, userid);
			rst=pst.executeQuery();
			EducationDetails educationDetails=null;
			while(rst.next())
			{
				String eduid=rst.getString(1);
				String collegename=rst.getString(2);
				String qualification=rst.getString(3);
				String stream=rst.getString(4);
				String grade=rst.getString(5);
				String fdate=rst.getString(6);
				String tdate=rst.getString(7);
				String description=rst.getString(8);
				String uid=rst.getString(9);
				educationDetails=new EducationDetails(eduid, collegename, qualification, stream, grade, fdate, tdate, description, uid);
				arrayedudetails.add(educationDetails);
			}
			
			
																					//mobile application
			if(ismobile.equals("1"))
			{
				
				wb.data=arrayedudetails;
				Gson gson=new Gson();
				String tojson=gson.toJson(wb);
				pw.write(tojson);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		if(module.equals("existingidea")|| module.equals("web"))
		{
			arrayideasubmit=new ArrayList<>();
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
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(module.equals("personaldetails") || module.equals("web"))
		{
			
			calendar=Calendar.getInstance();
			String getpersionaldetailquery="select emailid,mobilenumber,tempararyaddress from user where userId=?";
			try {
				pst=connection.prepareStatement(getpersionaldetailquery);
				pst.setString(1,userid);
				rst=pst.executeQuery();
				while(rst.next())
				{
				
					String email=rst.getString(1);
					String mobileno=rst.getString(2);
					String address=rst.getString(3);
					persionalDetails=new PersonalDetails(email, mobileno, address);
				}
				
				
				
				if(ismobile.equals("1"))                              //mobile application
				{
					wb.data=persionalDetails;
					Gson gson=new Gson();
					String tojson=gson.toJson(wb);
					pw.write(tojson);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		if(module.equals("skilldetails") || module.equals("web"))
		{
			
			arrayskills=new ArrayList<>();
			String myskillurl="select * from skills where userId=?";
			try {
				pst=connection.prepareStatement(myskillurl);
				pst.setString(1,userid);
				rst=pst.executeQuery();
				Skills skills=null;
				while(rst.next())
				{
					String skillid=rst.getString(1);
					String skillname=rst.getString(2);
					String uid=rst.getString(3);
					skills=new Skills(skillid, skillname, uid);
					arrayskills.add(skills);
				}
				
				
				if(ismobile.equals("1"))													//mobile application
				{
					
					wb.data=arrayskills;
					wb.result=true;
					Gson gson=new Gson();
					String tojson=gson.toJson(wb);
					pw.write(tojson);
				}															
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			if(module.equals("web"))
			{
				arraywebidea=new ArrayList<>();
				 String query1="select user.userId,ideasubmit.ideaid, ideasubmit.titlename,ideasubmit.idearegidate,ideasubmit.statusofidea from user,ideasubmit where user.userId=ideasubmit.userId and user.userId=? ";   	
		     	  try {
					pst=connection.prepareStatement(query1);
					 pst.setLong(1,uid);
			     	  rst=pst.executeQuery();
			     	   long dbid=0,dbideasubmitid=0;
			     	    String dbuserappli="", dbideatitle="",dbideadate="",dbideastatus="",dbemail="";
			     	    WebIdeaSubmit ideasubmit=null;
			     	    while(rst.next())
			     	    { //  dbuserappli=r.getString(1);
			     	    	dbid=rst.getLong(1);
			     	    	dbideasubmitid=rst.getLong(2);
			     	    	dbideatitle=rst.getString(3);
			     	    	dbideadate=rst.getString(4);
			     	    	dbideastatus=rst.getString(5);
			     	    ideasubmit=new WebIdeaSubmit(dbideasubmitid,dbid,dbideatitle,dbideadate,dbideastatus);
			     	    arraywebidea.add(ideasubmit);
			     	    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
			}
			
		}
	
	
		
		
		
		//code for web appplication
		if(module.equals("0"))
		{
			uid=Long.parseLong(userid);
			request.setAttribute("userid", uid);
			request.setAttribute("fullname", fname);
			request.setAttribute("basicdetails",basincdetails);
			request.setAttribute("educationdetails",arrayedudetails);
			request.setAttribute("exixtingidea",arraywebidea);
			request.setAttribute("personaldetails",persionalDetails);
			request.setAttribute("skilldetails",arrayskills);
			
			
			
			RequestDispatcher rd=request.getRequestDispatcher("/begin-dashboard.jsp");
        	rd.forward(request,response);
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
