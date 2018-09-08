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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/WebContent/WEB-INF/css/common.css">
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#btn').click(function(event) {
			var firstName = $('#firstName').val();
			var middleName = $('#middleName').val();
			var surName = $('#surName').val();
			$('#firstName').focus(function(){
				$('#error').empty();
				$('#error').removeClass("abc alert-danger");
				
			});
			if (firstName == "" || middleName == "" || surName == "") {
				$('#error').addClass("abc alert-danger");
				$('#error').text('required');
				event.preventDefault();
			} else {

			}
		});
	});
</script>
</head>
<body>
	<div style='margin-left: 200px; margin-right: 200px; margin-top: 30px;'>
		<div
			style='margin-left: 250px; margin-right: 250px; margin-top: 150px'>

			<table id=registrationTable>

				<tr>

					<td><div style='margin-left: 2px; margin-bottom: 3px'>
							<fmt:message key="registration.first.name" bundle="${bundle}"></fmt:message>
							<input type="text" id="firstName" />
							<div id="error"></div>
						</div></td>

				</tr>

				<tr>
					<td><fmt:message key="registration.middle.name"
							bundle="${bundle}"></fmt:message><input type="text"
						id="middleName" /></td>
				</tr>
				<tr>
					<td><fmt:message key="registration.surname" bundle="${bundle}"></fmt:message><input
						type="text" id="surName" /></td>
				</tr>
				<tr>
					<td><input type="submit" id="btn"
						value='<fmt:message key='registration.submit'
								bundle="${bundle}"></fmt:message>' /></td>
				</tr>

			</table>

		</div>

	</div>
	<strong class="abc">slfhla </strong>
</body>
</html>