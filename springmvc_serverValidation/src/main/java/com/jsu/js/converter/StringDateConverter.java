package com.jsu.js.converter;

import com.mysql.jdbc.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: String转换成Date类型
 * @author: sunc-idea
 * @time: 2020/4/28 18:21
 */
@Component
public class StringDateConverter implements Converter<String, Date> {
    private static final String datePattern = "yyyy/MM/dd";

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDate = null;
        Date date = null;
        if (!StringUtils.isNullOrEmpty(s)) {
            try {
                simpleDate = new SimpleDateFormat(datePattern);
                date = simpleDate.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
