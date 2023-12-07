package com.hourglass.hourglassbackend.service.impl;

import com.hourglass.hourglassbackend.entity.User;
import com.hourglass.hourglassbackend.mapper.UserMapper;
import com.hourglass.hourglassbackend.service.UserService;
import com.hourglass.hourglassbackend.utils.Md5Util;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void register(String username, String password) {
        String md5Password = Md5Util.getMD5String(password);
        userMapper.add(username, md5Password);
    }

    @Override
    public void update(@RequestBody @Validated User user){
    userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

}
