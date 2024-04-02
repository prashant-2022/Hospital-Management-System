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
            box-sizing: border-box;
        }
        body{
           
        }
        header{
            position: fixed;
           top: 0;
           left: 0;
           padding: 20px 10%;
           width: 100%;
          	background-color:gray;
           display: flex;
           justify-content: space-between;
           align-items: center;
           z-index: 100;
           border-bottom: 1px solid;
           
        }
       
        .logo{
            font-size: 25px;
            color: black;
            font-weight: 600;
        }
        .navbar a{
            font-size: 18px;
            color: black;
            text-decoration: none;
            font-weight: 500;
            margin-left: 35px;
            transition: .2s;
        }
        .navbar .Home{
            color: yellow;
        }
        .navbar a:hover
        {
            color: aquamarine;
           
        }
        </style>
</head>
<body>
	<header>
        <label class="logo">HMS</label>
        <nav class="navbar">
            <a href="index.jsp" class="Home">HOME</a>
            
            <a href="patient.jsp">PATIENT</a>
            <a href="doctor_logout">LOGOUT</a>
            
        </nav>
    </header>
</body>
</html>