package com.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.doctor_dao;

/**
 * Servlet implementation class delete_doctor
 */
@WebServlet("/delete_doctor")
public class delete_doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_doctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String did=request.getParameter("id");
		int id = Integer.parseInt(did);
		
		int status=doctor_dao.deleteDoc(id);
		if(status>0) {
			  request.setAttribute("status", "delete_success"); 
		        
		        // Forward the request to the JSP page
		        RequestDispatcher dispatcher = request.getRequestDispatcher("doctor.jsp");
		        dispatcher.forward(request, response);
		}else {
			 request.setAttribute("status", "delete_failed");
		        
		        // Forward the request to the JSP page
		        RequestDispatcher dispatcher = request.getRequestDispatcher("doctor.jsp");
		        dispatcher.forward(request, response);
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
