<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style="color:red">异常错误!</h1>
		错误信息:${requestScope.ex}
		<input type="button" value="返回列表页" onclick="location.href='${pageContext.request.contextPath}/house/list'">
	</center>
</body>
</html>