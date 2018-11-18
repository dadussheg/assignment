<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<c:set var="contextPath" value="${ pageContext.request.contextPath}" scope="application" />
<script type="text/javascript">
<%@include file = "/WEB-INF/js/common.js"%>
</script>
<style type="text/css">
<%@include file="/WEB-INF/css/common.css"%>
<%@include file="/WEB-INF/css/loginstyle.css"%>
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						
						//Login validations
						$('#signIn')
								.click(
										function(event) {
											$('#err').empty();
											if (($('#username').val() == "")
													&& ($('#password').val() == "")) {
												show_error($('#username'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												show_error($('#password'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												event.preventDefault();
											} else if ($('#username').val() == "") {
												show_error($('#username'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												event.preventDefault();
											} else if ($('#password').val() == "") {
												show_error($('#password'),
														'<fmt:message key="registration.field.required" bundle="${bundle}"/>');
												event.preventDefault();
											}

										});//login validations end

					});
</script>
</head>
<body id="mainbody">
<div class="wrapper">
<form action="${contextPath}/login" method="post" class="form-signin">
<h2 class="form-signin-heading">
<fmt:message key="login.login" bundle="${bundle}" />
</h2>

<c:if test="${not empty error}">
<div class="error_span" id="err">
<p class="alert-class fa fa-info-circle">${error}</p>
</div>
</c:if>
<c:if test="${not empty success}">
<div class="error_span" id="succ">
<p class="success-class fa fa-check-circle">${success}</p>
</div>
</c:if>
<div>
<input type="text" class="form-control" name="username" placeholder='<fmt:message key="login.username" bundle="${bundle}"/>' id="username" />
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
<div>
<input type="password" class="form-control" name="password" placeholder='<fmt:message key="login.password" bundle="${bundle}"/>' id="password" />
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
<div class="btn-group">
<button class="btn btn-success" type="submit" id="signIn">
<fmt:message key="login.signin" bundle="${bundle}" />
</button>
<a href="${contextPath}/registration"><button class="btn btn-primary" type="button" id="signUp">
<fmt:message key="login.signup" bundle="${bundle}" />
</button></a>
</div>
<br /> <a href="${contextPath}/forgetPassword"><fmt:message key="login.forget.password" bundle="${bundle}" /></a>

</form>
</div>
</body>
</html>