<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<%@include file="Component/AllCss.jsp" %>
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
      margin: 8px 0px;
      padding: 7px;
      width: 205px;
      border-radius: 20px;
      outline: none;
      border: none;
      border-bottom: 1px solid;
      background-color: white;
    }
    button{
      margin-top: 8px;
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
      <form action="admin_login" method="post">
       <h2>Admin Login</h2>
        <br>
        <input type="text" name="username" placeholder="Username" required>
        <br>
        <input type="password" name="password" placeholder="Password" required>
        <br>
        <button type="submit">Sign In</button>
        <br>
     <!--   <a href="">Create an account</a> -->
      </form>

    </div>
    <script>
        var status = document.getElementById("status").value;
        if (status === "failed") {
            Swal.fire('Failed', 'Invalid email password', 'error').then((result) => { 
                if (result.isConfirmed) { 
                    window.location.href = 'AdminLogin.jsp'; 
                }
            });
        }
    </script>
</body>
</html>