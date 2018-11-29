<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<form:form action="/MyDbTest/save" method="post"
		modelAttribute="user">
		<table align="center">
			<caption align="top">User details form</caption>
			<tr>
				<td>Enter your name:</td>
				<td><form:input path="fieldName" /></td>
				<td><form:errors path="fieldName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Select DataType:</td>
				<td><form:select path="type">
						<form:options items="${typeList}" />
					</form:select></td>
				<td><form:errors path="type" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Select cateogry:</td>
				<td><form:select path="cateogry">
						<form:options items="${cateogryList}" />
					</form:select></td>
				<td><form:errors path="cateogry" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>