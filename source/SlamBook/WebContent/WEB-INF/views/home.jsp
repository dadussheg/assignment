<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
</head>
<body>
<div style='left-margin:10px;'>
	<table>
	<fmt:bundle basename="src.resources.messages"><fmt:message key='MSGWEL001'/></fmt:bundle>

		<thead>
			<tr><th>ksjflashj</th></tr>
		</thead>

	</table>
</div>
<form action="<%=request.getContextPath()%>/login" method="get"> 
	<input type="submit" value = "English" name="language">
	<input type="submit" value = "Japanese" name = "language">
</form>
</body>
</html>