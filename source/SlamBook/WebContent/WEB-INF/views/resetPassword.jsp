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
	$(document).ready(function(){
		
		$('#newPassword').focus(function() {
			hide_error($('#newPasswordDiv'));
		});
		$('#confirmPassword').focus(function(){
			hide_error($('#confirmPasswordDiv'));
		});
		$('#submit').click(function(event){
			if($('#newPassword').val()=="" || $.trim($('#newPassword').val()).length==0){
				show_error($('#newPasswordDiv'), '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
				event.preventDefault();
			}
			if($('#confirmPassword').val()=="" || $.trim($('#confirmPassword').val()).length==0){
				show_error($('#confirmPasswordDiv'), '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
				event.preventDefault();
			}
		});
		
	});
</script>
</head>
<body>

<form action="${contextPath}/resetPassword" method="post">
		<div class = "outer_div">
		<div style='margin-bottom: 10px; text-align: center;'>
				<strong><fmt:message key="login.enter.password" bundle="${bundle}" /></strong>
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
									key="login.new.password" bundle="${bundle}" />:-
						</label></td>
						<td>
							<div id="newPasswordDiv">
								<input type="password" id="newPassword" name="newPassword"/>
								<div class="error_message"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td><label> <fmt:message
									key="login.confirm.password" bundle="${bundle}" />:-
						</label></td>
						<td>
							<div id="confirmPasswordDiv">
								<input type="password" id="confirmPassword" name="confirmPassword"/>
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