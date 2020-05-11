package com.jsu.js.validator;

import com.jsu.js.commons.RegexUtils;
import com.jsu.js.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @description:spring自带服务器验证
 * @author: sunc-idea
 * @time: 2020/4/28 22:00
 */
@Component
public class UserValidater implements Validator {

    //首先调用supports方法验证是不是 User对象
    //如果返回true,调用validate，否则不调用validate
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String name = user.getName();
        if (!RegexUtils.isNotNull(name)) {
            errors.rejectValue("name", "username.error.isnotnull");
           /* errors.rejectValue("name", "用户名不能为空");*/
        }
    }
}
