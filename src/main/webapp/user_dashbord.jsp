<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%@include file="userNavbar.jsp" %>
 	<c:if test="${empty userobj }">
 		<c:redirect url="UserLogin.jsp"></c:redirect>
 	</c:if>
</body>
</html>