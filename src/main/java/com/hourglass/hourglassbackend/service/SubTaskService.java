package com.hourglass.hourglassbackend.service;

import com.hourglass.hourglassbackend.entity.SubTask;

import java.util.List;

public interface SubTaskService {
    Integer createSubTask(String name, Integer taskId);

    Integer completeSubTask(Integer subTaskId);

    List<SubTask> getSubTaskList(Integer taskId);
}
