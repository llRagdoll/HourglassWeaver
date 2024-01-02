package com.hourglass.hourglassbackend.service;

import com.hourglass.hourglassbackend.dto.RecentTaskDTO;
import com.hourglass.hourglassbackend.dto.TaskDistributionDTO;
import com.hourglass.hourglassbackend.entity.User;

import java.util.List;

public interface UserService {


    void register(String username, String password);

    User getUserByName(String username);


    void update(String name, String email, String phone, String avatar);

    void updateAvatar(String avatarUrl);

    TaskDistributionDTO getTaskDistribution(Integer userId);

    List<RecentTaskDTO> getRecentTask(Integer userId);
}
