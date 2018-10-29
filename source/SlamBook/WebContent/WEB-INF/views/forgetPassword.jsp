<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<c:set var="contextPath" value="${ pageContext.request.contextPath}" scope="application" />
<script type="text/javascript">
<%@include file = "/WEB-INF/js/common.js"%>
</script>
<style type="text/css">
<%@include file="/WEB-INF/css/common.css"%>
</style>
<script type="text/javascript">
var emailRegex = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
$(document).ready(function(){
	 $('#submit').click(function(event){
		 $('#err').empty();
		 $('#email').focus(function() {
			hide_error($('#emailDiv'));
		});
		if($('#email').val()==""){
			show_error($('#emailDiv'),
			'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
			event.preventDefault();
		}else if(!emailRegex.test($('#email').val())){
			show_error($('#emailDiv'),
			'<fmt:message key="MSGLOGIN003" bundle="${bundle}"/>');
			event.preventDefault();
		}
	});
});
</script>
</head>
<body>
	<form action="${contextPath}/forgetPassword" method="post">
		<div class = "outer_div">
		<div style='margin-bottom: 10px; text-align: center;'>
				<strong><fmt:message key="login.enter.email" bundle="${bundle}" /></strong>
			</div>
			<c:if test="${not empty error}">
				<div class="error_message error_span">
					<span id="err">${error}</span>
				</div>
			</c:if>
			<div style='margin-left: 30px'>
				
				<table class = "login_table">
					<tr>
						<td><label> <fmt:message
									key="login.email" bundle="${bundle}" />:-
						</label></td>
						<td>
							<div id="emailDiv">
								<input type="text" id="email" name="email"/>
								<div class="error_message"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit"
							value='<fmt:message key="login.submit" bundle="${bundle}"/>'
							id="submit" /></td>
					</tr>
				</table>



			</div>
		</div>
	</form>
</body>
</html>