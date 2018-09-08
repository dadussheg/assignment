<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">
	
	$('#submit').click(function(event){
		var firstName = $('#firstName').val();
		var middleName = $('#middleName').val();
		var surName = $('#surName').val();
		alert(firstName);
		if (firstName == "" || middleName == "" || surName == "") {
			$('#error').addClass("alert alert-success");
			$('#error').text('required');
			event.PreventDefault();
		}else{
			
		}	
	});
	
</script>
</head>
<body>
	<div style='margin-left: 200px; margin-right: 200px; margin-top: 30px;'>
		<div
			style='margin-left: 250px; margin-right: 250px; margin-top: 150px'>
			<form <%-- action="<%=request.getContextPath()%>/registration" method="get" --%>>
				<table id=registrationTable>
					<tr>
						<td><fmt:message key="registration.first.name"
								bundle="${bundle}"></fmt:message><input type="text"
							id="firstName" />
						<div id="error"></div></td>
					</tr>
					<tr>
						<td><fmt:message key="registration.middle.name"
								bundle="${bundle}"></fmt:message><input type="text"
							id="middleName" /></td>
					</tr>
					<tr>
						<td><fmt:message key="registration.surname"
								bundle="${bundle}"></fmt:message><input type="text" id="surName" /></td>
					</tr>
					<tr>
						<td><input type="submit" id="surName" id = "submit" value='<fmt:message key='registration.submit'
								bundle="${bundle}"></fmt:message>'/></td>
					</tr>

				</table>
			</form>
		</div>

	</div>
</body>
</html>