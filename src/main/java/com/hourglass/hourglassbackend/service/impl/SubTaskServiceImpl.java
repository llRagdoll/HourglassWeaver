package com.hourglass.hourglassbackend.service.impl;

import com.hourglass.hourglassbackend.entity.SubTask;
import com.hourglass.hourglassbackend.mapper.SubTaskMapper;
import com.hourglass.hourglassbackend.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    @Autowired
    private SubTaskMapper subTaskMapper;

    @Override
    public Integer createSubTask(String name, Integer taskId) {
        return subTaskMapper.createSubTask(name,taskId);
    }

    @Override
    public Integer completeSubTask(Integer subTaskId) {
        return subTaskMapper.completeSubTask(subTaskId);
    }

    @Override
    public List<SubTask> getSubTaskList(Integer taskId) {
        return subTaskMapper.getSubTaskList(taskId);
    }


}
