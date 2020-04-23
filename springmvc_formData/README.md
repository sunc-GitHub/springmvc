# 在逆向工程中实现自定义类型处理器（typeHandlers）

1. **在`mybatis-generator.xml`的`table`标签中，添加`columnOverride`标签**

```xml
`<columnOverride column="birthDay"  property="birthDay" jdbcType="DATE" 			javaType="java.util.Date" />`
```

property：实体类属性名

jdbcType：数据库存储的类型

javaType：实体类属性数据类型

通过添加`columnOverride`，在Xml映射器（XXXMapper.xml）会生成(随便找的例子)

`#{birthDay,jdbcType=DATE},`

```xml
<if test="birthDay != null">
  #{birthDay,jdbcType=DATE},
</if>
```



2. **创建自定义类型处理器（typeHandlers）类，继承`BaseTypeHandler<JavaType类型>`**


```Java
@Component
@MappedJdbcTypes(JdbcType.DATE)//指定关联的 JDBC 类型：
@MappedTypes(Date.class)//使MyBatis 可以得知该类型处理器处理的 Java 类型
public class StringDateHandler extends BaseTypeHandler<Date> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nate = format.format(date);
        preparedStatement.setString(i,nate);
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Date date = resultSet.getDate(s);
        return date; 
        }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Date date = resultSet.getDate(i);
        return date;

    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = callableStatement.getDate(i);
        return date;
    }
}
```

3. **最后，可以让 MyBatis 帮你查找类型处理器：**

```
<!-- mybatis-config.xml -->
<typeHandlers>
  <package name="org.mybatis.example"/>
</typeHandlers>
```



这是官方具体的说法：

通过类型处理器的泛型，MyBatis 可以得知该类型处理器处理的 Java 类型，不过这种行为可以通过两种方法改变：

- 在类型处理器的配置元素（typeHandler 元素）上增加一个 `javaType` 属性（比如：`javaType="String"`）；
- 在类型处理器的类上增加一个 `@MappedTypes` 注解指定与其关联的 Java 类型列表。 如果在 `javaType` 属性中也同时指定，则注解上的配置将被忽略。

可以通过两种方式来指定关联的 JDBC 类型：

- 在类型处理器的配置元素上增加一个 `jdbcType` 属性（比如：`jdbcType="VARCHAR"`）；
- 在类型处理器的类上增加一个 `@MappedJdbcTypes` 注解指定与其关联的 JDBC 类型列表。 如果在 `jdbcType` 属性中也同时指定，则注解上的配置将被忽略。

当在 `ResultMap` 中决定使用哪种类型处理器时，此时 Java 类型是已知的（从结果类型中获得），但是 JDBC 类型是未知的。 因此 Mybatis 使用 `javaType=[Java 类型], jdbcType=null` 的组合来选择一个类型处理器。 这意味着使用 `@MappedJdbcTypes` 注解可以*限制*类型处理器的作用范围，并且可以确保，除非显式地设置，否则类型处理器在 `ResultMap` 中将不会生效。 如果希望能在 `ResultMap` 中隐式地使用类型处理器，那么设置 `@MappedJdbcTypes` 注解的 `includeNullJdbcType=true` 即可。 然而从 Mybatis 3.4.0 开始，如果某个 Java 类型**只有一个**注册的类型处理器，即使没有设置 `includeNullJdbcType=true`，那么这个类型处理器也会是 `ResultMap` 使用 Java 类型时的默认处理器。
