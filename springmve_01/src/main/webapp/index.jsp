<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="userTest/testMethod"> testMethod</a>
<a href="userTest/testParameter?name=12">testParameter</a>

<form method="post" action="userTest/testEncoding?name=12">
    <input type="text" name="name">
    <input type="submit" value="点击">
</form>

<a href="userTest/testPathVarible/name=张">testPathVarible</a>

<a href="userTest/testModelAndView?name=张">testModelAndView</a>
<a href="userTest/testRedict">testRedict</a>

</body>
</html>