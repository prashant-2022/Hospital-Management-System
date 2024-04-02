package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.user_dao;
import com.model.Entity;

/**
 * Servlet implementation class user_register
 */
@WebServlet("/user_register")
public class user_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_register() {
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
		PrintWriter pw = response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Entity ob = new Entity();	
		ob.setName(name);
		ob.setEmail(email);
		ob.setPassword(password);
		user_dao dob = new user_dao();
		boolean b=dob.UserRegister(ob);
		
		if(b==true) {
			//pw.print("data inserted successfully");
			
			 request.setAttribute("status", "success");
		        
		        // Forward the request to the JSP page
		        RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
		        dispatcher.forward(request, response);
			
			//response.sendRedirect("UserLogin.jsp");
		}else {
			//pw.print("data not inserted, somethind went wrong.");
			
			response.sendRedirect("signup.jsp");
		}
		
	}

}
