<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>success</p>
<p>${goods.price}</p>
<p>${goods.quantity}</p>
<p>${goods.date}</p>


<%--
   message标签，负责从资源文件中获取数据 ，code就是资源文件中的key
--%>
<spring:message code="hello"></spring:message>

</body>
</html>

