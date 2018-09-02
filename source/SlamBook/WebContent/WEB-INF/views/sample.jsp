<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale" %>
<%@page import="org.apache.taglibs.standard.tag.el.fmt.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.common{
	color:red;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
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
	});
</script>
</head>
<body>
<h1>
</h1>
<form action="<%=request.getContextPath()%>/login" method="get" id="form">
<input type="submit" value="SUBMIT" id="english" name="language"/>${englishName}
<input type="radio" value="" id="japanese"/>${japaneseName}
</form>
<table border="2px" class="abc">
<thead>
<tr>
<th>25</th>
<th>30</th>
<th>46</th>
<th>55</th></tr>
</thead>
<tbody>
<tr><td class="common">sfsfg</td><td>vxbvc</td><td>sgf</td><td>cvbxch</td></tr>
<tr><td>sfsfg</td><td>vxbvc</td><td>sgf</td><td>cvbxch</td></tr>
<tr><td>sfsfg</td><td>vxbvc</td><td>sgf</td><td>cvbxch</td></tr>
<tr><td>sfsfg</td><td>vxbvc</td><td>sgf</td><td>cvbxch</td></tr>
<tr id="smth"><td>sfsfg</td><td>vxbvc</td><td>sgf</td><td>cvbxch</td></tr>

</tbody>
</table>
</body>
</html>