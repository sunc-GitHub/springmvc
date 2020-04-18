<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    springmvc的表单:必须和一个pojo对象绑定
    modelAttribute="user" 表单和user对象绑定，在请求作用域中查找user
    不能直接访问springmvc表单页面，需要进行一次跳转，
    将user对象放入request域中
--%>
<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/userTest/saveUser.action">
    <p>
        <label>用户名:</label>
        <form:input path="name"/>
    </p>
    <p>
        <label>密码:</label>
        <form:password path="passWord"/>
    </p>
    <input type="submit">
</form:form>

</body>
</html>

