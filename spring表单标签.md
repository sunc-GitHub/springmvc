## spring表单标签

`<form:标签名>`

1. <form:form modelAttribute="域中的对象">
   	页面会自动将域中的对象赋值到对应的表单中

2. <form:input path="属性名">
   	提交时将表单里的数据赋值到域中对象的"属性名"中,或者将当前域中对象的属性赋值到页面上

3. <form:radiobutton path="属性名" value="值" />
   	springm表单的单选按钮

4. <form:checkbox path="属性名" value="值"/>
   	springm表单的复选框，对应的"属性"必须是数组才能接收到数据

5. <form:errors path="属性名">
   	结合服务器校验使用