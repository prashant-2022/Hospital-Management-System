<%@page import="com.dao.doctor_dao"%>
<%@page import="com.dao.user_dao"%>
<%@page import="com.dao.appointment_dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	.wrapper{
		padding-left:7%;	
	}
	.card {
  width:250px; /* Adjust based on your layout */
  margin: 20px;
  background-color: #f4f4f4;
  border: 1px solid #ddd;
  margin-top:20%;
   margin-left:10%;
  border-radius: 5px;
  padding: 20px;
  display: inline-block;
  box-sizing: border-box;
  vertical-align: top;
  align-item:centre;
}

@media (max-width: 768px) {
  .card {
    width: calc(50% - 20px);
  }
}

@media (max-width: 480px) {
  .card {
    width: calc(100% - 20px);
  }
}
	
	
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://kit.fontawesome.com/efe4c1785b.js" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="adminNavbar.jsp" %>
<div class="wrapper">
<%
	//int c = doctor_dao.getCount();
%>
  <div class="card">
  <h2><i class="fa-solid fa-user-doctor"></i></h2>
  <p>Doctor</p>
  <p><%= doctor_dao.getCount() %></p>
</div>

<div class="card">
  <h2><i class="fa-solid fa-users"></i></h2>
  <p>Users</p>
  <p><%=user_dao.getCount() %></p>
</div>

<div class="card">
  <h2><i class="fa-solid fa-calendar-check"></i></h2>
  <p>Total Appointments</p>
  <p><%=appointment_dao.getCount() %></p>
</div>
</div>
</body>
</html>