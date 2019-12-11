<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<div align="center">Update Registration</div>
	<form action="getAndUpdate" method="PUT">
		<table border="1" align="center">

			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="id" id="id"
					value="${data.id}"></td>
			</tr>
			<tr>
				<td>Employee Name ${counter.count}</td>
				<td><input type="text" name="empname" id="empname"
					value="${data.empname}"></td>
			</tr>
			<tr>
				<td>Employee Company</td>
				<td><input type="text" name="empcom" id="empcom"
					value="${data.empcom}"> <%--  ${item.empcom}">--%></td>

			</tr>
			<tr>
				<td>Employee Mob</td>
				<td><input type="text" name="empmob" id="empmob"
					value="${data.empmob}"> <%-- ${item.empmob}"> --%></td>
			</tr>
			<tr>
				<td>Employee Email</td>
				<td><input type="text" name="empemail" id="empemail"
					value="${data.empemail}"> <%--  ${item.empemail}">--%></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" name="go"
					value="Update-Regester"> || <input type="reset" name="reset"
					value="Reset"></td>

			</tr>

		</table>
	</form>

</body>
</html>