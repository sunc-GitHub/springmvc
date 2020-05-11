package com.jsu.js.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: next door
 * @Date: 2020/4/22 23:02
 * @Description:类型处理器 String->Date
 * @Component spring扫描管理
 */
@Component
@MappedJdbcTypes(JdbcType.DATE)
@MappedTypes(Date.class)
public class DateHandler extends BaseTypeHandler<Date> {


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
