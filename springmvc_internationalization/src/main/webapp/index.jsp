<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<div style="width: 300px;margin: auto" >
    <form action="goodController/saveGoods" method="post">
        价格：<input name="price"/>
        <br>
        数量：<input name="quantity"/>
        <br>
        日期：<input name="date" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}"/>
        <br>
        <input type="submit" value="提交"/>
    </form>
</div>

<h3>springmvc国际化</h3>
<a href="il8n/sessionLocaleResover?requst_Locale=zh_CN">中文</a>
<a href="il8n/sessionLocaleResover?requst_Locale=en_US">英文</a>
</body>
</html>