<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<p>success</p>
<p>${goods.price}</p>
<p>${goods.quantity}</p>
<p>${goods.date}</p>


<%--
   message标签，负责从资源文件中获取数据 ，code就是资源文件中的key
--%>
<h3><spring:message code="hello"/></h3>


<select id="language">
    <option value="zh_CN">中文</option>
    <option value="en_US">英文</option>
</select>


<script src="static/js/jquery.min.js"></script>
<script>
    $(function () {
        $("#language").val("${sessionScope.language}");
        $("#language").change(function () {
            var localeValue = $(this).val();
            window.location.href = "il8n/sessionLocaleResover?requst_Locale=" + localeValue;
        });
    });
</script>
</body>
</html>

