<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<style type="text/css">
    .error {
        font-size: 18px;
        color: red;
    }
</style>
<body>
<form id="form" modelAttribute="user" enctype="multipart/form-data" method="post"
      action="userController/saveUser.action">
    <fieldset>
        <legend>Add a User</legend>
        <p>
            <label>用户名:</label>
            <input type="text" name="name"/>
            <span id="name" class="error"></span>
        </p>
        <p>
            <label>密码:</label>
            <input type="passWord" name="passWord"/>
            <span id="passWord" class="error"></span>
        </p>
        <p>
            <label>婚姻:</label>
            <span> <input type="radio" name="marriage" value="true"><label>是</label></span>
            <span> <input type="radio" name="marriage" value="false"><label>否</label></span>
            <span id="marriage" class="error"></span>
        </p>
        <p>
            <label>爱好:</label>
            <span>
                        <input type="checkbox" name="hobby" value="篮球"/><label>篮球</label>
                        <input type="checkbox" name="hobby" value="电影"/><label>电影</label>
                        <input type="checkbox" name="hobby" value="音乐"/><label>音乐</label>
                    </span>
            <span id="hobby" class="error"></span>
        </p>
        <p>
            <label>人脉:</label>
            <span>
                        <input type="checkbox" name="contacts" value="张三"/><label>张三</label>
                        <input type="checkbox" name="contacts" value="李四"/><label>李四</label>
                        <input type="checkbox" name="contacts" value="王五"/><label>王五</label>
                        <input type="checkbox" name="contacts" value="赵六"/><label>赵六</label>
                    </span>
            <span id="contacts" class="error"></span>
        </p>
        <p>
            <label>职业:</label>
            <select name="carrer">
                <option value="">请选择</option>
                <option value="0">律师</option>
                <option value="1">教师</option>
                <option value="2">警察</option>
                <option value="3">法官</option>
            </select>
            <span id="carrer" class="error"></span>
        </p>
        <p>
            <label>户籍:</label>
            <select name="houseRegister">
                <option value="">请选择</option>
                <option value="0">北京</option>
                <option value="1">上海</option>
                <option value="2">广州</option>
                <option value="3">深圳</option>
            </select>
            <span id="houseRegister" class="error"></span>
        </p>
        <p>
            <label>生日:</label>
            <input type="text" name="birthDay"/>
            <span id="birthDay" class="error"></span>
        </p>
        <p>
            <label>个人描述:</label>
            <textarea name="remark" rows="5"></textarea>
            <span id="remark" class="error"></span>
        </p>
        <p>
            <label>文件上传:</label>
            <input type="file" name="multipartFile" multiple="multiple">
        </p>
        <p>
            <label>文件上传:</label>
            <input type="file" name="multipartFile" multiple="multiple">
        </p>
        <p id="buttons">
            <input id="reset" type="reset">
            <input id="submit" value="提交" type="button">
            <input id="submits" value="测试提交" type="button">
        </p>
    </fieldset>
</form>
<script src="static/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#submit").click(function () {
            /*var formJSON = $("#form").serialize();*/
            var formJSON = new FormData(document.getElementById("form"));
            console.log(formJSON);
            $.ajax({
                url: "userController/saveUser.action",
                type: "post",
                data: formJSON,
                dataType: "json",//以json格式返回数据
                contentType: false,
                processData: false,
                cache: false,
                async: true,
                success: function (data) {
                    if (data.flag == false) {
                        $("span[class = 'error']").empty();
                        $.each(data.data, function (key, value) {
                            $("#" + key).html(value);
                        })
                    } else {
                        window.location.href = "${pageContext.request.contextPath}/jsp/success.jsp";
                    }
                },
                error: function () {
                    console.log("提交失败")
                }
            });
        });


        $("#submits").click(function () {
            $.ajax({
                url: "userController/testSave.action",
                type: "post",
                data: JSON.stringify({'name': 'root'}),
                contentType: "application/json",
                success: function (data) {
                    console.log("传输成功" + data);
                },
                error: function () {
                    console.log("传输失败");
                }
            })
        });
    });
</script>
</body>
</html>

