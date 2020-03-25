<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	<form:form action="${pageContext.request.contextPath}/loginUser" method="post" modelAttribute="user">
		<table>
			<tr>
				<td colspan="100">
					<h1>登录页面</h1>
					<font color="red">
						${requestScope.errorMessage}
					</font>
				</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>
					<form:input path="userName"/>
					<form:errors path="userName"/>
				</td>
				
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<form:password path="userPassword"/>
					<form:errors path="userPassword"/>
				</td>
			</tr>
			<tr>
				<td colspan="100">
					<form:button>登录</form:button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>