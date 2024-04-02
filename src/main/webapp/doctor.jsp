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
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

.container {
  display: flex;
  margin-top: 90px; 
margin-left:10px;
margin-right:10px;

}

.vertical-form,
.horizontal-list {
  padding: 40px;
  box-sizing: border-box;
  border: 1px solid #ccc; /* Adding border to both boxes */
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Adding box shadow */
  border-radius: 8px; /* Adding border radius */
}

.vertical-form {
  flex: 1; /* Change flex value to 1 */
  margin-right: 20px; /* Adding gap between both divs */
}

.vertical-form h2 {
  color: #333;
  text-align: center; /* Centering h2 */
}

.vertical-form form {
  max-width: 300px; /* Reduce max-width of the form */
  margin: 0 auto;
}

.vertical-form label {
  display: block;
  margin-bottom: -9px;
  margin-top: 5px;
}

.vertical-form input {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  box-sizing: border-box;
  border-radius:7px;
  outline:none;
}

.vertical-form input[type="submit"] {
  background-color: #333;
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
  margin-top: 10px;
}

.horizontal-list h2 {
  color: #333;
  text-align: center; /* Centering h2 */
}

.horizontal-list {
 
  
  
  overflow-x: auto; /* Add horizontal scroll if content overflows */
}


table,th,td{
		border:1px solid;
		border-collapse:collapse;
	}
	td{
		padding:5px;
	}
table {
            width: 100%; /* Adjust width to 100% */
            margin: 20px auto;
            border: 1px solid #333;
            border-collapse: collapse;
            background-color: #fff;
        }

        th, td {
            border: 1px solid #333;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
        
        .edit-btn{
        	padding: 5px 10px; 
        	background-color: #007bff; 
        	color: #fff; 
        	text-decoration: none; 
        	border-radius: 3px;
        }
        .delete-btn{
        	padding: 5px 10px;
        	 background-color: #dc3545;
        	  color: #fff; 
        	  text-decoration: none;
        	 border-radius: 3px;
        }
  </style>
	 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

</head>
<body>
<%@include file="adminNavbar.jsp" %>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">

<div class="container">
  <div class="vertical-form">
    <h2>Add Doctor</h2>
    <form action="add_doctor" method="post">

        <label for="">name</label><br>
        <input type="text" name="name" required><br>
        <label for="">Date of Birth</label><br>
        <input type="date" name="dob" required><br>
        <label for="">Qualification</label><br>
        <input type="text" name="qualification" required><br>
        <label for="">Specilization</label><br>
        <input type="text" name="specilization" required><br>
        <label for="">email</label><br>
        <input type="email" name="email" required><br>
        <label for="">contact</label><br>
        <input type="number" name="contact" required><br>
        <label for="">password</label><br>
        <input type="text" name="password" required><br>
        <input type="submit" >
    </form>
  </div>

  <div class="horizontal-list">
    <h2>Doctors List</h2>
    <table>
            <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Qualification</th>
                <th>Spesilization</th>
                <th>email</th>
                <th>contact</th>
                <th>password</th>
                <th>Action</th>
            </tr>
        <% 
        List<Doctor_Entity> ob = doctor_dao.getDocotor();
        		
        %>
        <% for(Doctor_Entity d:ob){ %>
            <tr>
              <!--  <td><%= d.getId() %></td> -->
                <td><%= d.getName() %></td>
                <td><%= d.getDob() %></td>
                <td><%= d.getQualification() %></td>
                <td><%= d.getSpecilization() %></td>
                <td><%= d.getEmail() %></td>
                <td><%= d.getContact() %></td>
                <td><%= d.getPassword() %></td>
                <td>
					<a href="edit_doctor.jsp?id=<%=d.getId() %>" class="edit-btn">Edit</a>		
					<a href="delete_doctor?id=<%=d.getId() %>" class="delete-btn">Delete</a>		
				</td>
            </tr>
            
            <%} %>
    </table>
  </div>
</div>
 <script>
        var status = document.getElementById("status").value;
        if (status === "success") {
            Swal.fire('Success', 'Doctor added successfully!', 'success').then((result) => { 
                if (result.isConfirmed) { 
                    window.location.href = 'doctor.jsp'; 
                }
            });
        }
       
        else if (status === "failed") {
            Swal.fire('failed', 'failed to add doctor', 'failed').then((result) => { 
                if (result.isConfirmed) { 
                    window.location.href = 'doctor.jsp'; 
                }
            });
        }else  if (status === "delete_success") {
            Swal.fire('Success', 'Doctor deleted successfully!', 'success').then((result) => { 
                if (result.isConfirmed) { 
                    window.location.href = 'doctor.jsp'; 
                }
            });
        }
        else if (status === "delete_failed") {
            Swal.fire('failed', 'failed to delete doctor', 'failed').then((result) => { 
                if (result.isConfirmed) { 
                    window.location.href = 'doctor.jsp'; 
                }
            });
        }
        else if (status === "update_success") {
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
        
    </script>
</body>
</html>