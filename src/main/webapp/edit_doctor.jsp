<%@page import="com.dao.doctor_dao"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Doctor_Entity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4; /* Adds a light background color */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Full viewport height */
    margin: 0; /* Remove default body margin */
  }
  
  .container {
    width: 450px; /* Fixed width for the container */
    padding: 40px; /* Adjusted padding */
    background-color: #fff; /* Sets a white background for the container */
    border: 1px solid #ddd; /* Adds a subtle border */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Adds a shadow for depth */
    border-radius: 10px; /* Rounds the corners */
    display: flex; /* Enable flexbox for container */
    flex-direction: column; /* Stack children vertically */
    align-items: center; /* Center-align children */
  }
  
  .vertical-form {
    width: 100%; /* Form takes full width of the container */
  }
  
  .vertical-form h2 {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .vertical-form label {
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  .vertical-form input[type="text"],
  .vertical-form input[type="date"],
  .vertical-form input[type="email"],
  .vertical-form input[type="number"] {
    width: 94%; /* Inputs take full width of form */
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .vertical-form input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%; /* Button takes full width of form */
  }
  
  .vertical-form input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
	
	
	<div class="container">
  <div class="vertical-form">
    <h2>Edit Doctor details</h2>
    <form action="update_doctor" method="post">
		<% 
		String did = request.getParameter("id");
		int id =Integer.parseInt(did);
		Doctor_Entity d=doctor_dao.getDocotorById(id);
		%>
        <label for="">name</label><br>
        <input type="text" name="name" value="<%=d.getName()%>" required><br>
        <label for="">Date of Birth</label><br>
        <input type="date" name="dob" value="<%=d.getDob()%>" required><br>
        <label for="">Qualification</label><br>
        <input type="text" name="qualification" value="<%=d.getQualification()%>" required><br>
        <label for="">Specilization</label><br>
        <input type="text" name="specilization" value="<%=d.getSpecilization()%>" required><br>
        <label for="">email</label><br>
        <input type="email" name="email" value="<%=d.getEmail()%>" required><br>
        <label for="">contact</label><br>
        <input type="number" name="contact" value="<%=d.getContact()%>" required><br>
        <label for="">password</label><br>
        <input type="text" name="password" value="<%=d.getPassword()%>" required><br>
       	<input type="hidden" name="id" value="<%=d.getId()%>"><br>
        <input type="submit" value="update" >
    </form>
  </div>
  </div>
  <!--  <input type="hidden" id="status" value="<%= request.getAttribute("status") %>"> 
  <script>
    var status = "<%= request.getAttribute("status") %>";
    if (status === "update_success") {
        Swal.fire('Success', 'Doctor information updated successfully!', 'success').then((result) => {
            if (result.isConfirmed) {
                window.location.href = 'doctor.jsp';
            }
        });
    } else if (status === "update_failed") {
        Swal.fire('Failed', 'Failed to update information', 'error').then((result) => {
            if (result.isConfirmed) {
                window.location.href = 'doctor.jsp';
            }
        });
    }
</script> -->
</body>
</html>