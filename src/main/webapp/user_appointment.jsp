
<%@page import="com.dao.doctor_dao"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Doctor_Entity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    h2{
    margin-top:90px;
        text-align: center;
    }
    form {
        max-width: 800px;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    label {
        font-weight: bold;
    }

    input[type="text"],
    input[type="date"],
    input[type="number"],
    input[type="email"],
    input[type="tel"],
    select,
    textarea {
        width: calc(100% - 22px); /* Adjusted width */
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    td {
        vertical-align: top;
        width: 50%;
    }

    @media screen and (max-width: 600px) {
        td {
            display: block;
            width: 100%;
        }
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
    }
</style>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<%@include file="userNavbar.jsp" %>
<c:if test="${empty userobj }">
 		<c:redirect url="UserLogin.jsp"></c:redirect>
 	</c:if>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
	<h2>Appointment Form</h2>

<form action="user_appointment" method="post">
    <table>
        <tr>
            <td>
                <label for="name">Name</label><br>
                <input type="text" id="name" name="name" required>
            </td>
            <td>
                <label for="gender">Gender</label><br>
               
                <input type="text"  name="gender" required>
               
            </td>
        </tr>
        <tr>
            <td>
                <label for="age">Age</label><br>
                <input type="number" id="age" name="age" required>
            </td>
            <td>
                <label for="appointment_date">Appointment Date</label><br>
                <input type="date" id="appointment_date" name="appointDate" required>
            </td>
        </tr>
        <tr>
            <td>
                <label for="email">Email</label><br>
                <input type="email" id="email" name="email" required>
            </td>
            <td>
                <label for="phone">Phone no.</label><br>
                <input type="tel" id="phone" name="contact" required>
            </td>
        </tr>
        <tr>
            <td>
                <label for="disease">Disease</label><br>
                <input type="text" id="disease" name="disease" required>
            </td>
            <td>
                <label for="doctor">Doctor</label><br>
                <select id="doctor" name="doctor" required>
                    <option value="">Select Doctor</option>
                   <% 
                   List<Doctor_Entity> li = doctor_dao.getDocotor();
                		for(Doctor_Entity d:li){
                   %>
                   <option value="<%=d.getId() %>"><%=d.getName() %>(<%=d.getSpecilization() %>)</option>
                   <% 
                		}
                   %>
                    
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <label for="address">Full Address</label><br>
                <textarea id="address" name="address" rows="4" required></textarea>
            </td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
<script>
var status = document.getElementById("status").value;
if (status === "success") {
    Swal.fire('Success', 'Appointment booked successfully', 'success').then((result) => { 
        if (result.isConfirmed) { 
            window.location.href = 'user_appointment.jsp'; 
        }
    });
}
else if (status === "failed"){
    Swal.fire('Failed', 'Something went wrong', 'error').then((result) => { 
        if (result.isConfirmed) { 
            window.location.href = 'user_appointment.jsp'; 
        }
    });
}

</script>
</body>
</html>