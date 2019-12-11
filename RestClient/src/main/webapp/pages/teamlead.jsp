<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<title>Data Fetch From Database</title>
</head>
<body>
 <h2>Fetch data from database in Spring MVC</h2>
 
 <table border="1">
<tr>
    	<td>Serial No</td> 
    	<td>Employee-ID</td> 
    	<td align="center">NAME</td>
    	<td align="center">COMPANY NAME</td>
		<td align="center">EMAIL</td>
		<td align="center">MOB</td>
		<td align="center">Action</td>
</tr>
		
		<c:forEach var="item" items="${data}" varStatus="counter" >
			<tr>
			    <td>${counter.count}</td>
			    <td>${item.id}</td>
			    <td><input type="text" name="empname" id="empname" value="${item.empname}"></td>
			    <td><input type="text" name="empcom" id="empcom" value="${item.empcom}"></td>
				<td><input type="text" name="empcom" id="empcom" value="${item.empemail}"></td>				
				<td><input type="text" name="empmob" id="empmob" value="${item.empmob}"></td>
				<td>
					<a href="${pageContext.request.contextPath }/update/${item.id}" onclick="return confirm('Are you sure want to Update?')">Want Update</a> &nbsp; || &nbsp;
					<a href="${pageContext.request.contextPath }/delete/${item.id}" onclick="return confirm('Are you sure?')">Delete</a>
				</td>
		   </tr>
		</c:forEach>
	</table>
</body>
</html>