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
	$(document)
			.ready(
					function() {
						$('#username').focus(function() {
							hide_error($('#userNameDiv'));
						});
						$('#password').focus(function() {
							hide_error($('#passwordDiv'));
						});
						//Login validations
						$('#signIn')
								.click(
										function(event) {
											$('#err').empty();
											if (($('#username').val() == "")
													&& ($('#password').val() == "")) {
												show_error($('#userNameDiv'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												show_error($('#passwordDiv'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												event.preventDefault();
											} else if ($('#username').val() == "") {
												show_error($('#userNameDiv'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												event.preventDefault();
											} else if ($('#password').val() == "") {
												show_error($('#passwordDiv'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												event.preventDefault();
											}

										});//login validations end

					});
</script>
</head>
<body>
	<form action="${contextPath}/login" method="post">
		<div class = "outer_div">
			<div style='margin-bottom: 10px; text-align: center;'>
				<strong><fmt:message key="login.login" bundle="${bundle}" /></strong>
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
									key="login.username" bundle="${bundle}" />:-
						</label></td>
						<td>
							<div id="userNameDiv">
								<input type="text" id="username" name="username"/>
								<div class="error_message"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td><label> <fmt:message key="login.password"
									bundle="${bundle}" />:-
						</label></td>
						<td>
							<div id="passwordDiv">
								<input type="password" id="password" name="password" />
								<div class="error_message"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit"
							value='<fmt:message key="login.signin" bundle="${bundle}"/>'
							id="signIn" /><input type="button"
							value='<fmt:message key="login.signup" bundle="${bundle}"/>'
							id="signUp" /></td>
					</tr>
					<tr>
					<td><a href ="${contextPath}/forgetPassword"><fmt:message key="login.forget.password" bundle="${bundle}"/></a></td>
					</tr>
				</table>



			</div>
		</div>
	</form>
</body>
</html>