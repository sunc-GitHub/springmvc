package com.jsu.js.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: sunc-idea
 * @Date: 2020/4/24
 */

@Component
/*public interface Converter<S, T>* S-source , T-targe */
public class StringDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat format;
        Date date = null;

        try {
            if (!s.isEmpty()) {
                format = new SimpleDateFormat("yyyy/MM/dd");
                date = format.parse(s);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
