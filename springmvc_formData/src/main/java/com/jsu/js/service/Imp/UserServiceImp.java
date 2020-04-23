package com.jsu.js.service.Imp;

import com.jsu.js.dao.UserMapper;
import com.jsu.js.pojo.User;
import com.jsu.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Auther: next door
 * @Date: 2020/4/22 21:18
 * @Description:
 */
@Service("userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(User user) {
        return userMapper.insertSelective(user) > 0 ? true : false;
    }
}
