<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href="/dataFetchFromDB">View Employee Details</a></p>

<div align="center">User Registration</div>
<form action="getAndSave" method="post">
<table border="1" align="center">
<tr>
<td>Employee Name</td>
<td><input type="text" name="empname" id="empname" value=""></td>
</tr>
<tr>
<td>Employee Company</td>
<td><input type="text" name="empcom" id="empcom" value=""></td>

</tr>
<tr>
<td>Employee Mob</td>
<td><input type="text" name="empmob" id="empmob" value=""></td>
</tr>
<tr>
<td>Employee Email</td>
<td><input type="text" name="empemail" id="empemail" value=""></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" name="go" value="Self-Regester"> || 
<input type="reset" name="reset" value="Reset">
</td>

</tr>
</table>
</form>

</body>
</html>