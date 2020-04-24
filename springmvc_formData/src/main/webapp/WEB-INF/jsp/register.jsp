<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    items 准备的数据，不能为空
    //register.jsp itmes 接收的数据类型
    //1.map类型 value = map.key,显示的map.value
    //2.数组类型
    //3.集合
    //4.集合对象 itemValue,itemLabel 为option标签的name ,显示值
--%>
<form:form modelAttribute="user" method="post"
           action="${pageContext.request.contextPath}/userController/saveUser.action">
<fieldset>
    <legend>Add a User</legend>
    <p>
        <label>用户名:</label>
        <form:input path="name"/>
    </p>
    <p>
        <label>密码:</label>
        <form:password path="passWord"/>
    </p>
    <p>
        <label>婚姻:</label>
        <form:checkbox path="marriage" value="已婚"/>
    </p>
    <p>
        <label>爱好:</label>
        <%--1.map类型 value = map.key,显示的map.value
            HashMap<Integer, String> hobbies = new HashMap<Integer, String>();
            hobbies.put(1, "篮球");
        --%>
        <form:checkboxes items="${hobbies}" path="hobby"/>
    </p>
    <p>
        <label>人脉:</label>
        <%--3.集合类型
        --%>
        <%-- name = contact --%>
        <form:checkboxes path="contacts" items="${contacts}"/>
        <%--<form:checkbox path="contacts" value=""/>--%>
    </p>
    <p>
        <label>职业:</label>
        <form:select path="carrer">
            <option/>
            请选择职业
            <%--2.数组类型
             new String[]{"教师", "学生", "医生", "IT民工", "其它"}
            --%>
            <form:options items="${careers }"/>
        </form:select>
    </p>
    <p>
        <label>户籍:</label>
        <form:select path="houseRegister">
            <option>请选择户籍</option>
            <%--4.集合对象 itemValue,itemLabel 为option标签的name ,显示值
                id，name 为实体对象的属性
            --%>
            <form:options items="${houseRegister}" itemValue="id" itemLabel="name" />

        </form:select>
    </p>
    <p>
        <label>日期:</label>
        <form:input path="birthDay"></form:input>
    </p>
    <p>
        <label>个人描述:</label>
        <form:textarea path="remark" rows="5"/>
    </p>
    <p id="buttons">
        <input id="reset" type="reset">
        <input id="submit" type="submit">
    </p>
</fieldset>
</form:form>
</html>

