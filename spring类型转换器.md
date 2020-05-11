## 一. 类型转换器(可以实现任意类型到任意类型到转换)

1. 实现Converter<源类型,目标类型>,重写方法

 	2. 在类上加上@Component注解
 	3. 在springmvc的配置文件注册

```java
<!--类型转换器注册-->
<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
        <list>
            <bean class="com.jsu.js.converter.StringDateConverter"/>
        </list>
    </property>
</bean>

<mvc:annotation-driven conversion-service="conversionService"/>                      
```


## 二. 格式化器(只能实现String到目标类型的相互转换)

​	1.实现Formatter<目标类型>,重写方法
​	2.在类上加上@Component注解
​	3.在springmvc的配置文件注册

```java
<!--
  可以将类型转换器和格式化器同时注册在FormattingConversionServiceFactoryBean中注册
         -->
<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
    <!--类型转换器注册-->
    <property name="converters">
        <list>
            <bean class="com.jsu.js.converter.StringDateConverter"/>
        </list>
    </property>
    <!--格式化器-->
    <property name="formatters">
        <list>
            <bean class="com.jsu.js.converter.DateFormater"/>
        </list>
    </property>
</bean>
                
<mvc:annotation-driven conversion-service="conversionService"/>  
```


