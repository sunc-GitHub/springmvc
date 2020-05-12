<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/userController/ajaxForm">ajax表单提交</a>

<h3>异常处理</h3>
<a href="${pageContext.request.contextPath}/exception/sqlException">sqlException</a>
<a href="${pageContext.request.contextPath}/exception/myException">自定义异常</a>
<a href="${pageContext.request.contextPath}/exception/defaultException">默认异常</a>
<a href="${pageContext.request.contextPath}/exception/404">404</a>

<h3>拦截器</h3>
<a href="${pageContext.request.contextPath}/interceptor/page1">默认异常</a>
<a href="${pageContext.request.contextPath}/exception/404">404</a>
</body>
</html>

