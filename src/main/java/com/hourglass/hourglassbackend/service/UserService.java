package com.hourglass.hourglassbackend.service;

import com.hourglass.hourglassbackend.entity.User;

public interface UserService {


    void register(String username, String password);

    User getUserByName(String username);


    void update(User user);

    void updateAvatar(String avatarUrl);
}
