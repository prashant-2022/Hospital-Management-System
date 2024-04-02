package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.appointment_dao;
import com.model.Appointment_Entity;
import com.model.Entity;

/**
 * Servlet implementation class user_appointment
 */
@WebServlet("/user_appointment")
public class user_appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_appointment() {
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

		 HttpSession session = request.getSession();
	        Entity user = (Entity) session.getAttribute("userobj");
	        int userId = user.getId(); // Retrieve user ID from the session
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String appointDate = request.getParameter("appointDate");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String disease = request.getParameter("disease");
		String doctorid = request.getParameter("doctor");
		int doctorId =Integer.parseInt(doctorid);
		String address = request.getParameter("address");
		//String status1="pending";
		
		Appointment_Entity ob = new Appointment_Entity(userId, name, gender, age, appointDate, email, contact, disease, doctorId, address);
		int status = appointment_dao.addAppointment(ob);
		if(status>0) {
			request.setAttribute("status", "success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_appointment.jsp");
	        dispatcher.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_appointment.jsp");
	        dispatcher.forward(request, response);
		}
		
	}

}
