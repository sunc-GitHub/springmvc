package com.jsu.js.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Auther: next door
 * @Date: 2020/4/22 23:02
 * @Description:类型处理器 String[]->Date
 * @Component spring扫描管理
 */
@Component
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String[].class)
public class StringArrayHandler extends BaseTypeHandler<String[]> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, Arrays.toString(strings));
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return s.split(",");
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i).split(",");
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i).split(",");
    }
}
