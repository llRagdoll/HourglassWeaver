package com.hourglass.hourglassbackend.service.impl;

import com.hourglass.hourglassbackend.entity.Task;
import com.hourglass.hourglassbackend.mapper.TaskMapper;
import com.hourglass.hourglassbackend.service.TaskService;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void add(Task task){
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        task.setUserId(userId);
        taskMapper.add(task);
    }
}
