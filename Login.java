package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
      }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		
			
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email1=request.getParameter("email1");
		String pass1=request.getParameter("pass1");
		
		if(email1.equals("sakthikathir97@gmail.com")&&pass1.equals("7667321752"))
		{
			response.sendRedirect("welcomeForm.jsp");
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("email1",email1);
		doGet(request, response);
	}

}
