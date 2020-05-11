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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: next door
 * @Date: 2020/4/22 23:02
 * @Description:类型处理器 String->Date
 * @Component spring扫描管理
 */
@Component
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Boolean.class)
public class BooleanHandler extends BaseTypeHandler<Boolean> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        if(aBoolean){
            preparedStatement.setString(i,"1");
        }else {
            preparedStatement.setString(i,"0");
        }
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if("1".equals(s)){
            return true;
        }else if ("0".equals(s)){
            return false;
        }
        return null;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if("1".equals(resultSet.getString(i))){
            return true;
        }else if ("0".equals(resultSet.getString(i))){
            return false;
        }
        return null;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if("1".equals(callableStatement.getString(i))){
            return true;
        }else if ("0".equals(callableStatement.getString(i))){
            return false;
        }
        return null;
    }
}
