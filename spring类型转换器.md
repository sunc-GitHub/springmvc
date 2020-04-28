## 一. 类型转换器(可以实现任意类型到任意类型到转换)

	1. 实现Converter<源类型,目标类型>,重写方法
 	2. 在类上加上@Component注解
 	3. 在springmvc的配置文件注册

```java
<bean class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
         <list>
             <bean class="自定义的转换器"/>
         </list>
    </property>
</bean>
```


## 二. 格式化器(只能实现String到目标类型的相互转换)

​	1.实现Formatter<目标类型>,重写方法
​	2.在类上加上@Component注解
​	3.在springmvc的配置文件注册

```java
<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
    <property name="formatters">
        <list>
            <bean class="com.jsu.wyj.converter.DateFormatter"/>
        </list>
    </property>
</bean>
```



## 三. 必须加上<mvc:annotation-driven conversion-service="conversionService"/>