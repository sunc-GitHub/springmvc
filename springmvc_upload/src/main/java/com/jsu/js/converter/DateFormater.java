package com.jsu.js.converter;

import com.mysql.jdbc.StringUtils;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/4/28 21:43
 */
@Component
public class DateFormater implements Formatter<Date> {
    private static final String datePattern = "yyyy/MM/dd";
    private SimpleDateFormat simpleDate;


    //String类型转换成Date
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        Date date;
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

    //Date类型进行输出
    @Override
    public String print(Date date, Locale locale) {
        simpleDate = new SimpleDateFormat(datePattern);
        return simpleDate.format(date);
    }
}
