<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    .error {
        font-size: 18px;
        color: red;
    }
</style>
<body>
<%--
    springmvc的表单:必须和一个pojo对象绑定
    modelAttribute="user" 表单和user对象绑定，在请求作用域中查找user
    不能直接访问springmvc表单页面，需要进行一次跳转，
    将user对象放入request域中

    items 准备的数据，不能为空
    //register.jsp itmes 接收的数据类型
    //1.map类型  checkbox.value = map.key,label等于map.value
    //2.数组类型
    //3.集合
    //4.集合对象 itemValue,itemLabel 分别为option标签的name ,显示值
--%>
<form:form modelAttribute="user" method="post" enctype="multipart/form-data"
           action="${pageContext.request.contextPath}/userController/saveUser.action">
    <fieldset>
        <legend>Add a User</legend>
        <p>
            <label>用户名:</label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="error"/>
        </p>
        <p>
            <label>密码:</label>
            <form:password path="passWord"/>
            <form:errors path="passWord" cssClass="error"/>
        </p>
        <p>
            <label>婚姻:</label>
            <form:checkbox path="marriage" value="已婚"/>
            <form:errors path="marriage" cssClass="error"/>
        </p>
        <p>
            <label>爱好:</label>
                <%--1.map类型  checkbox.value = map.key,label等于map.value
                    HashMap<Integer, String> hobbies = new HashMap<Integer, String>();
                    hobbies.put(1, "篮球");
                --%>
            <form:checkboxes items="${hobbies}" path="hobby"/>
            <form:errors path="hobby" cssClass="error"/>
        </p>
        <p>
            <label>人脉:</label>
                <%--3.集合类型
                --%>
                <%-- name = contact --%>
            <form:checkboxes path="contacts" items="${contacts}"/>
            <form:errors path="contacts" cssClass="error"/>
        </p>
        <p>
            <label>职业:</label>
            <form:select path="carrer">
                <option>请选者</option>
                <%--2.数组类型
                 new String[]{"教师", "学生", "医生", "IT民工", "其它"}
                --%>
                <form:options items="${careers}"/>
            </form:select>
            <form:errors path="carrer" cssClass="error"/>
        </p>
        <p>
            <label>户籍:</label>
            <form:select path="houseRegister">
                <%--4.集合对象 itemValue,itemLabel 为option标签的name ,显示值
                    id，name 为实体对象的属性
                --%>
                <form:options items="${houseRegister}" itemValue="id" itemLabel="name"/>
            </form:select>
            <form:errors path="houseRegister" cssClass="error"/>
        </p>
        <p>
            <label>生日:</label>
            <form:input path="birthDay"/>
            <form:errors path="birthDay" cssClass="error"/>
        </p>
        <p>
            <label>个人描述:</label>
            <form:textarea path="remark" rows="5"/>
        </p>
        <p>
            <label>文件上传:</label>
            <input type="file" name="multipartFile">
        </p>
        <p>
            <label>文件上传:</label>
            <input type="file" name="multipartFile">
        </p>
        <p id="buttons">
            <input id="reset" type="reset">
            <input id="submit" type="submit">
        </p>
    </fieldset>
</form:form>
</body>
</html>

