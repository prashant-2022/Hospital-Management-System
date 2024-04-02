package com.Doctor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.doctor_dao;
import com.dao.user_dao;
import com.model.Doctor_Entity;
import com.model.Entity;

/**
 * Servlet implementation class doctor_login
 */
@WebServlet("/doctor_login")
public class doctor_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctor_login() {
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
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session=request.getSession();
		
		Doctor_Entity ob = doctor_dao.doctor_login(email, password);
		if(ob != null) {
			session.setAttribute("docobj", ob);
			response.sendRedirect("doctor_dashbord.jsp");
		}else {
			 request.setAttribute("status", "failed");
		        
		        
			 RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorLogin.jsp");

		        dispatcher.forward(request, response);
		}
	}
}
