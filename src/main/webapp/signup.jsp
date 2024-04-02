<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    *{
      margin: 0;
      padding: 0;
    }
    body{
    
    }
    .wrapper{
      position: absolute;
      border: 1px solid;
      top: 30%;
      left: 40%;
      padding: 40px;
      text-align: center;
      font-family: Arial, Helvetica, sans-serif;
      width: 350px;
      border-radius: 20px;
      background-color: rgb(252, 253, 249);
      box-shadow: 0px 5px 20px 10px;
      opacity: .8;
    }
  
    input{
      margin: 5px 0px;
      padding: 7px;
      width: 205px;
      border-radius: 20px;
      outline: none;
      border: none;
      border-bottom: 1px solid;
      background-color: white;
    }
    button{
      margin-top: 5px;
      margin-bottom: 25px;
      width: 220px;
      height: 30px;
      font-size: 15px;
      border-radius: 20px;
      outline: none;
      border: none;
      border-bottom: 1px solid;
      background-color: rgb(254, 254, 15);
    }
    button:focus{
      background-color:  rgb(210, 210, 10);
    }
   </style>
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<%@include file="Navbar.jsp" %>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
<div class="wrapper">
      <form action="user_register" method="post">
       <h2>User Register</h2>
        <br>
        <input type="text" name="name" placeholder="name" required>
        <br>
        <input type="email" name="email" placeholder="email" required>
        <br>
        <input type="password" name="password" placeholder="Password" required>
        <br>
         <input type="password" name="cnfpassword" placeholder="confirmPassword" required>
        <br>
        <button type="submit">Sign Up</button>
        <br>
      <P>Already have an account?<a href="UserLogin.jsp">Login</a></P>
      </form>

    </div>
    
	   <script>
   
        var status = document.getElementById("status").value;
        if (status === "success") {
            Swal.fire('Success', 'Registration successful!', 'success').then((result) => { 
                if (result.isConfirmed) { 
                    window.location.href = 'UserLogin.jsp'; 
                }
            });
        }
    </script>
	
</body>
</html>