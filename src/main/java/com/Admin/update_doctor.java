package com.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.doctor_dao;
import com.model.Doctor_Entity;

/**
 * Servlet implementation class update_doctor
 */
@WebServlet("/update_doctor")
public class update_doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_doctor() {
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
		
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("qualification");
		String specilization = request.getParameter("specilization");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		String did= request.getParameter("id");
		int id = Integer.parseInt(did);
		Doctor_Entity ob = new Doctor_Entity(id,name,dob,qualification,specilization,email,contact,password);
		
		int status = doctor_dao.UpdateDoctor(ob);
//		HttpSession session = request.getSession();
		if(status>0) {

			  request.setAttribute("status", "update_success"); 
		        
		        // Forward the request to the JSP page
		        RequestDispatcher dispatcher = request.getRequestDispatcher("doctor.jsp");
		        dispatcher.forward(request, response);
		}else {
			 request.setAttribute("status", "update_failed");
	        
	        // Forward the request to the JSP page
	        RequestDispatcher dispatcher = request.getRequestDispatcher("doctor.jsp");
	        dispatcher.forward(request, response);
		}
		
		
		
	}

}
