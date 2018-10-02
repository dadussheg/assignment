<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.taglibs.standard.tag.el.fmt.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.common {
	color: red;
}

.xyzy {
	background-color: #ddd;
	cursor: not-allowed;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		var todayDate = new Date();
		var currentHH = todayDate.getHours();
		var lenOfTh = $('.xyz th').length;
		var rowLength = $('.xyz tr').length;
		for(var i=0;i<lenOfTh;i++){
			var thText = $('.xyz th:eq("'+i+'")').text();
			var thHH = thText.split(':')[0];			
			if(thHH<currentHH){				
				var tdLength = $('.xyz td').eq(i).length;
				for(var j=1;j<rowLength;j++){
					$('.xyz tr:eq("'+j+'") td:eq("'+i+'")').addClass('xyzy');
				}
				
			}
		}
		
		$('#english').change(function(){			
			$('#japanese').prop('checked',false);
			
			//$('#form').submit();
		<%--  	$.ajax({
				method : 'GET',
				data : {
					"language":$(this).val()
				},
				url : '<%=request.getContextPath()%>/login',
				type :'json',
				success : function(){
					//alert("success");
					$('#spn').text('success');
				}
			});  --%>
		});
		$('#japanese').change(function(){
			result = "2";
			$('#english').prop('checked',false);
						
		});
		$('.abc td').click(function(){			
			var td = $(this).index();
			var tr = $(this).parent();
			var tbody = tr.parent();
			var thread =tbody.parent();
			var th = thread.find('thread').find('tr').find('th');
			$(th[0]).css( "background-color", "red" );
			alert('Td Index '+$(this).index());
			alert('Tr Index '+$(this).parent().index());
			alert($('.abc th:eq("'+td+'")').text());
			$('.abc th:eq("'+td+'")').addClass('common');
			for(var i=0;i<3;i++){
				$('#smth').after('<tr><td>aklsfkl</td><td>YES</td></tr>');
			}
		});
		$(document).on('hover','.common',function(){
		alert('YES');
		},function(){
			alert('NO');
		});
		//$('.xyz tr:gt(1)').each(function(){
			//alert('inside tr');
		$('.xyz tr:gt(1)').each(function(){
			$('.xyz th:gt(1)').each(function(){
			//alert('inside th ')
			var startTime = 36000;
			var endTime = 41400;
			var thText = $(this).text().split(":")[0]*60*60+$(this).text().split(":")[1]*60;
			
			if(thText>=startTime && thText<=endTime){
				$('.xyz td:eq("'+$(this).index()+'")').css('background-color',"red");
			}
		
			//alert();
		});
		
		});
	});
</script>
</head>
<body>
	<h1></h1>
	<form action="<%=request.getContextPath()%>/login" method="get"
		id="form">
		<input type="submit" value="SUBMIT" id="english" name="language" />${englishName}
		<input type="radio" value="" id="japanese" />${japaneseName}
	</form>
	<table border="2px" class="abc">
		<thead>
			<tr>
				<th>25</th>
				<th>30</th>
				<th>46</th>
				<th>55</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="common">sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr id="smth">
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
		</tbody>
	</table>
	<br>
	<table border="2px" class="xyz">
		<thead>
			<tr>
				<th>MeetingRoomName</th>
				<th>ID</th>
				<th>09:00</th>
				<th>09:30</th>
				<th>10:00</th>
				<th>10:30</th>
				<th>11:00</th>
				<th>11:30</th>
				<th>12:00</th>
				<th>12:30</th>
				<th>13:00</th>
				<th>13:30</th>
				<th>14:00</th>
				<th>14:30</th>
				<th>15:00</th>
				<th>15:30</th>
				<th>16:00</th>
				<th>16:30</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
				<td>sfsfg</td>
				<td>vxbvc</td>
				<td>sgf</td>
				<td>cvbxch</td>
			</tr>
		</tbody>
	</table>
</body>
</html>