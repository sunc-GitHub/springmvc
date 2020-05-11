## springmvc 数据绑定

　　数据绑定是将用户输入绑定到领域模型的一种特性，在Spring MVC的controller和view数据传递中，基于HTTP请求的特性，所有HTTP请求参数的类型均为字符串，如果模型领域需要绑定的类型为double或int，则需要手动进行类型转换，而有了数据绑定后，就不需要手动将HTTP请求中的String类型转换为模型需要的类型了，数据绑定的另一个好处是，当输入验证失败时，会重新生成一个HTML表单，无需重新填写输入字段。

## springmvc 表单标签

​		表单标签库中有input、password、hidden、textarea、checkbox、checkboxes、radiobutton、radiobuttons、select、option、options、errors。表单标签有acceptCharset、commandName、cssClass、cssStyle、htmlEscape、modelAttribute等属性。

1. input标签：input标签渲染`<input type="text"/>`元素，这个标签最重要的是path属性，该字段将输入绑定到form backing object的一个属性。如下所示，这个input标签被绑定到了user对象的userName属性上

   ```java
   <form:form modelAttribute="user" method="post" action="userSave">
       <fieldset>
           <p>
               <label for="userName">用户名:</label>
               <form:input path="userName"/>
           </p>
       </fieldset>
   </form:form>
   ```

2. password标签：渲染`<input type="password"/>`元素，password标签与input标签相似，只不过它有一个showPassword属性。

3. textare标签：渲染一个HTML的textarea元素。textarea基本上就是支持多行输入的input元素。

4. checkbox标签：渲染`<input type="checkbox"/>`元素，同样是通过path属性实现数据绑定，同时checkboxes渲染多个checkbox元素。

5. option：渲染一个选项元素，options：渲染多个选项元素。

   对于options和checkboxs有三个比较重要的属性

   **items**：用于生成input元素的Collect ion、Map或Array。
   **itemLabel**：items 属性中指定的集合对象的属性，为每个input元素提Label标签
   **itemValue**：items属 性中指定的集合对象的属性，为每个input元素提供value。

6. radiobutton标签渲染`<input type="radio"/>`元素，radiobuttons渲染多个radio元素。

7. select标签：渲染一个HTML的select元素，被渲染元素的选项可能来自赋予其items属性的Collection、Map、Array，或者来自一个嵌套的option或options标签。





## 数据绑定实现

1. index.jsp 发送请求到Usercontorller中，Usercontroller接收请求，并在request域中存储一个空的`user`对象


   		springmvc的表单:必须和一个pojo对象绑定,通过`modelAttribute="对象" `属性和user对象绑定，在request作用域中查找user。所以不能直接访问springmvc表单页面，需要进行一次跳转，将user对象放入request域中

2. 前端	

```java
<form:form modelAttribute="user" method="post"         action="${pageContext.request.contextPath}/userController/saveUser.action">
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
            <%--4.集合对象 例如List<User> 
                id，name 为实体对象(User)的属性
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
```

3. 后端进行接收

```java
 @RequestMapping(value = "saveUser.action", method = RequestMethod.POST)
    public String saveUser(User user, Model model) {
    }
```



