### 1. springmvc_formDate （springmvc表单标签和数据绑定demo）

* [在逆向工程中实现自定义类型处理器（typeHandlers)](https://github.com/sunc-GitHub/springmvc/blob/master/springmvc_formData/README.md)

### 2. springmvc_01(springmvc Controller可以返回的数据类型)

### 3. springmvc_converter(spring 自定义类型转换器 )

springmvc 将前端传递的数据自动封装成bean对象，发现数据不能为空，否则报400错误

前端

```java
<form action="goodController/saveGoods" method="post">
    价格：<input name="price"/>
    <br>
    数量：<input name="quantity"/>
    <br>
    <input type="submit" value="提交"/>
</form>
```

后端

```java
@RequestMapping("saveGoods")
public String saveGoods(Goods goods, Model model){
    model.addAttribute("goods",goods);
    return "success";
}
```

### 4. springmvc_internationalization(springmvc国际化)

### 5. springmvc_serverValidation(服务器验证)

### 6. springmvc_upload(springmvc文件上传，文件下载)

### 7.springmvc_ajx(ajax表单提交，json数据接收，异常处理)

* ajax 提交
* json
* 异常处理

`@RequestMapping有两个参数`

* consumes：指定浏览器传递到服务器的数据
* produces：服务器响应的数据

```Java
@RequestMapping(value = "xx", consumes ="application/json;charset=utf-8",produces ="application/json;charset=utf-8")
```

这里指定了必须接收json数据

## 其他

springmvc.xml

```xml
<!--
自动转发
path接收url view-name转发页面
-->
<mvc:view-controller path="userController/ajaxForm" view-name="Ajaxregister"/>

<!--
   DispatchServlet不拦截静态资源
   http://localhost:8080/springmvc_05_i18n_war_exploded/static/js/jquery.min.js
-->
<mvc:resources mapping="/static/**" location="/static/" />
```

