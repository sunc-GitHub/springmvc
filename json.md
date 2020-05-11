## springmvc json处理

* 添加在方法上面

`@ResponseBody`:支持服务器向客户端发送各种数据，将java对象自动转换成json格式

* 添加在发放形参上面

`@RequestBody`:

## ajax 有两种方式提交 

### 1.json字符串提交

```javascript
 $("#submits").click(function () {
    $.ajax({
        url: "userController/testSave.action",
        type: "post",
        data:JSON.stringify({'name': 'root'}),
        contentType: "application/json",
        success: function (data) {
            console.log("传输成功" + data);
        },
        error: function () {
            console.log("传输失败");
        }
    })
});
```

### 2. 以表单数据提交

**Form表单序列化提交**

```javascript
$.ajax({  
     url: "",  
     type: "POST",
     contentType:"application/x-www-form-urlencoded",//发送数据以key=value的形式传递,默认
     data: $('#uploadForm').serialize(),  
     success: function(data) {     
     },  
     error: function(data) {
     } 
});
```

如上，通过`$('#uploadForm').serialize()`可以对 form 表单进行序列化，从而将 form 表单中的所有参数传递到服务端。

但是上述方式，只能传递一般的参数，上传文件的文件流是无法被序列化并传递的。不过如今主流浏览器都开始支持一个叫做 `FormData` 的对象，有了这个对象就可以轻松地使用 Ajax 方式进行文件上传了。

**使用 FormData 进行 Ajax 请求并上传文件**

```javascript
function upload() {  
     var formData = new FormData($("#uploadForm")[0]);  
     $.ajax({  
          url: '',  
          type: 'POST',  
          data: formData,   
          cache: false,  
          contentType: false,  
          processData: false,  
          success: function(data) {
          },  
          error: function(data) {     
          }  
     });  
}
```

`FormData`对象必须接收的javaScript对象，所以`$("#uploadForm")`jquery对象必须转成javascript对象，+[0]。