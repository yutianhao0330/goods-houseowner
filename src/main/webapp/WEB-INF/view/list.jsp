<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<table>
		<tr>
			<th colspan="100">
				<h1>房产信息</h1>
				<c:if test="${not empty sessionScope.user}">
					当前用户:${sessionScope.user.userName}
				</c:if>
			</th>
		</tr>
		<tr>
			<td colspan="100">
				<form id="queryForm" action="${pageContext.request.contextPath}/house/list" method="post">
					<input type="hidden" name="pageNum">
					房主姓名:
					<input type="text" name="ownerName" value="${ownerName}">
					房产坐落地址:
					<input type="text" name="houseAddress" value="${houseAddress}">
					<input type="submit" value="查询">
					<input type="button" value="添加" onclick="location.href='${pageContext.request.contextPath}/house/add'">
				</form>
			</td>
		</tr>
		<tr>
			<th>房产编号</th>
			<th>房主姓名</th>
			<th>坐落地址</th>
			<th>用途</th>
			<th>面积(平方米)</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.houseList}" var="house">
			<tr>
				<td>${house.houseId}</td>
				<td>
					<c:forEach items="${house.owners}" var="owner">
						<c:if test="${not empty ownerName and fn:contains(owner.ownerName,ownerName)}">
							<font color="red">${owner.ownerName}</font>
						</c:if>
						<c:if test="${empty ownerName or not fn:contains(owner.ownerName,ownerName)}">
							${owner.ownerName}
						</c:if>
					</c:forEach>
				</td>
				<td>${house.houseAddress}</td>
				<td>${house.houseUse}</td>
				<td>${house.houseArea}</td>
				<td>
					<input type="button" value="修改" onclick="location.href='${pageContext.request.contextPath}/house/update?houseId=${house.houseId}'">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="100">
				第${page.pageNum}/${page.pages}页，共${page.total}条
				<input type="button" value="首页" onclick="page(1)">
				<input type="button" value="上一页" onclick="page(${page.prePage})">
				<input type="button" value="下一页" onclick="page(${page.nextPage})">
				<input type="button" value="尾页" onclick="page(${page.pages})">
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function page(pageNum){
		$(":hidden[name='pageNum']").val(pageNum);
		$("#queryForm").submit();
	}
</script>

</html>