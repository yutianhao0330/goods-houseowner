<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index3.css">
<body>
	<form action="${pageContext.request.contextPath}/house/addHouse" method="post" enctype="multipart/form-data" onsubmit="return check()">
		<table>
			<tr>
				<td>房产坐落地址</td>
				<td>
					<input type="text" name="houseAddress">
				</td>
			</tr>
			<tr>
				<td>房产用途</td>
				<td>
					<input type="text" name="houseUse">
				</td>
			</tr>
			<tr>
				<td>房产面积</td>
				<td>
					<input type="text" name="houseArea">
				</td>
			</tr>
			<tr>
				<td>户主</td>
				<td id="owners">
					
				</td>
			</tr>
			<tr>
				<td>不动产权证书</td>
				<td>
					<input type="file" name="myFile">
				</td>
			</tr>
			<tr>
				<td colspan="100">
					<input type="reset" value="重置">
					<input type="submit" value="增加">
				</td>
			</tr>
		</table>		
	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/owner/list",
			type:"post",
			dataType:"json",
			success:function(ownerList){
				var html = "";
				$(ownerList).each(function(index,owner){
					html+="<input type='checkbox' name='oids' value="+owner.ownerId+">"+owner.ownerName+"</input>";
				})
				$("td#owners").append(html);
			}
		})
	})
	function check(){
		if($(":checked[name='oids']:checked").length==0){
			alert("至少选择一个户主！");
			return false;
		}
		return true;
	}
</script>
</html>