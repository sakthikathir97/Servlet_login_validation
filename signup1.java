package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class signup1
 */
@WebServlet("/signup1")
public class signup1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email1");
		String name=request.getParameter("name1");
		String phone=request.getParameter("phone");
		String address=request.getParameter("add");
		RequestDispatcher rd=null;
		Connection conn=null;
		String Dburl="jdbc:mariadb://localhost:3306/radiator";
		String Uname="root";
		String Pword=null;
				
		
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection(Dburl,Uname,Pword);
			String strQuery="Select * from temperature1 where name ='"+name+"'";
			Statement st=(Statement) conn.createStatement();
			ResultSet rs=st.executeQuery(strQuery);
			
			if(rs.next())
			{
				out.print("display success..");
			}
			
		
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection(Dburl,Uname,Pword);
			String insert="insert into temperature1(email,name,phone,address)"+ "values(?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(insert);
			
			
			st.setString(1,email);
			st.setString(2,name);
			st.setString(3,phone);
			st.setString(4,address);
			
			
			
			int i=st.executeUpdate();
			
			if(i>0)
			{
				out.print("you are success.");
			}
			
			st.close();
			conn.close();
			out.close();
			
			
		}
		
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		
		
		
		doGet(request, response);
	}

}
