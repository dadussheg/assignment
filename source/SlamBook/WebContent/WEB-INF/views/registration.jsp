<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" scope="application" />
<script type="text/javascript">
  
<%@include file = "/WEB-INF/js/common.js"%>
  
</script>
<style type="text/css">
<%@include file="/WEB-INF/css/common.css"%>
<%@include file="/WEB-INF/css/loginstyle.css"%>
</style>
<script type="text/javascript">
  var emailRegex = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
  $(document)
      .ready(
          function() {
            $('#signUp')
                .click(
                    function(event) {
                      $('#err').empty();
                      $('#succ').empty();
                      /* hide_error($('#email'));
                      hide_error($('#fname'));
                      hide_error($('lname'));
                      hide_error($('#password'));
                      hide_error($('#confirmPassword'));
                      hide_error($('#spn')); */
                      if ($('#email').val() == "" && $('#fname').val() == ""
                          && $('#lname').val() == ""
                          && $('#password').val() == ""
                          && $('#confirmPassword').val() == "") {
                        show_error($('#email'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        show_error($('#fname'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        show_error($('#lname'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        show_error($('#password'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        show_error($('#confirmPassword'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      }
                      if ($('#fname').val() == ""
                          || $.trim($('#fname').val()).length == 0) {
                        show_error($('#fname'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      }
                      if ($('#lname').val() == ""
                          || $.trim($('#lname').val()).length == 0) {
                        show_error($('#lname'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      }
                      if ($('#email').val() == "") {
                        show_error($('#email'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      } else if (!emailRegex.test($('#email').val())) {
                        show_error($('#email'),
                            '<fmt:message key="MSGLOGIN003" bundle="${bundle}"/>');
                        event.preventDefault();
                      }
                      if ($('#password').val() == ""
                          || $.trim($('#password').val()).length == 0) {
                        show_error($('#password'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      }if ($('#confirmPassword').val() == ""
                          || $.trim($('#confirmPassword').val()).length == 0) {
                        show_error($('#confirmPassword'),
                            '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      }else if($('#confirmPassword').val()!=$('#password').val()){
                        show_error($('#confirmPassword'),
                        '<fmt:message key="MSGREG003" bundle="${bundle}"/>');
                        $('#password').val("");
                        $('#confirmPassword').val("");
                        event.preventDefault();
                      }
                      if(!$('input[type="radio"]:checked').length){
                        show_error($('#spn'),
                        '<fmt:message key="registration.field.required" bundle="${bundle}"/>');
                        event.preventDefault();
                      }
                    });
          });
</script>
</head>
<body id="mainbody">
<div class="wrapper">
<form action="${contextPath}/registration" method="post" class="form-signin">
<h2 class="form-signin-heading">
<fmt:message key="login.signup" bundle="${bundle}" />
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
<div class="col-sm-13">
<div class="row">
<div class="col-xs-3">
<label class="firstname"><fmt:message key="registration.fname" bundle="${bundle}" />:</label>
</div>
<div class="col-xs-9">
<input type="text" name="fname" id="fname" placeholder='<fmt:message key="registration.fname" bundle="${bundle}"/>' class="form-control required">
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
</div>
</div>

<div class="col-sm-13">
<div class="row">
<div class="col-xs-3">
<label class="lastname"><fmt:message key="registration.lname" bundle="${bundle}" />:</label>
</div>
<div class="col-xs-9">
<input type="text" name="lname" id="lname" placeholder='<fmt:message key="registration.lname" bundle="${bundle}"/>' class="form-control required">
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
</div>
</div>
<div class="col-sm-13">
<div class="row">
<div class="col-xs-3">
<label class="mail"><fmt:message key="registration.email" bundle="${bundle}" />:</label>
</div>
<div class="col-xs-9">
<input type="text" name="email" id="email" placeholder='<fmt:message key="registration.email" bundle="${bundle}"/>' class="form-control required">
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
</div>
</div>

<div class="col-sm-13">
<div class="row">
<div class="col-xs-3">
<label class="pass"><fmt:message key="registration.password" bundle="${bundle}" />:</label>
</div>
<div class="col-xs-9 required">
<input type="password" name="password" id="password" placeholder='<fmt:message key="registration.password" bundle="${bundle}"/>' class="form-control required">
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
<div class="col-xs-3">
<label class="pass"><fmt:message key="registration.confirm.password" bundle="${bundle}" />:</label>
</div>
<div class="col-xs-9 required">
<input type="password" name="confirmPassword" id="confirmPassword" placeholder='<fmt:message key="registration.confirm.password" bundle="${bundle}"/>' class="form-control required">
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
</div>
</div>
<div class="col-sm-13">
<div class="row">
<div class="col-xs-3 ">
<label class="gender"><fmt:message key="registration.gender" bundle="${bundle}" />:</label>
</div>
<div>
<div class="col-xs-4 male">
<input type="radio" name="gender" id="gender" value="M" />
<fmt:message key="registration.male" bundle="${bundle}" />
</div>

<div class="col-xs-4 female">
<input type="radio" name="gender" id="gender" value="F" />
<fmt:message key="registration.female" bundle="${bundle}" />
</div>
<span id = spn></span>
<p class="alert-class">
<i class="fa"></i>
</p>
</div>
</div>
</div>
<div class="btn-group">
<button class="btn btn-success" type="submit" id="signUp">
<fmt:message key="login.signup" bundle="${bundle}" />
</button>
<a href="${contextPath}/login"><button class="btn btn-primary" type="button" id="signIn">
<fmt:message key="login.signin" bundle="${bundle}" />
</button></a>
</div>
<br />
</form>
</div>
</body>
</html>




