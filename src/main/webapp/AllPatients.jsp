<%@page import="com.dao.appointment_dao"%>
<%@page import="com.dao.doctor_dao"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Doctor_Entity"%>
<%@page import="com.model.Appointment_Entity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Patients</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h2 {
            margin-top: 80px;
            text-align: center;
        }

        .table-container {
            margin: 20px auto;
            max-width: 1000px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<%@include file="adminNavbar.jsp" %>
<h2>Patients List</h2>

<div class="table-container">
    <table>
        <thead>
            <tr>
                <th>NAME</th>
                <th>GENDER</th>
                <th>AGE</th>
                <th>APPOINTMENT DATE</th>
                <th>EMail</th>
                <th>CONTACT</th>
                <th>DOCTOR</th>
                <th>DISEASE</th>
                <!--  
                <th>Status</th>
                 <th>ACTION</th>
                 -->
            </tr>
        </thead>
        <tbody>
            
         <%
           
            	
            	List<Appointment_Entity> li= appointment_dao.getAllApointments();
           		for(Appointment_Entity ob :li){
           			 Doctor_Entity d = doctor_dao.getDocotorById(ob.getDoctorId());
            	%>
            <tr>
                <td><%=ob.getName() %></td>
                <td><%=ob.getGender() %></td>
                <td><%=ob.getAge() %></td>
                <td><%=ob.getAppointDate() %></td>
                <td><%=ob.getEmail() %></td>
                <td><%=ob.getContact() %></td>
                <td><%=d.getName() %></td>
                <td><%=ob.getDisease() %></td>
               
            </tr>
          <%} %>
        </tbody>
    </table>
</div>
</body>
</html>