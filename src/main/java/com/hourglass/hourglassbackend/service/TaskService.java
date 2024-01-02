package com.hourglass.hourglassbackend.service;

import com.hourglass.hourglassbackend.dto.HistoryTaskDTO;
import com.hourglass.hourglassbackend.dto.TaskUndoneDTO;
import com.hourglass.hourglassbackend.entity.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {

    void createTask(Task task);

    Integer deleteTask(Integer taskId);

    List<Task> getTaskList();

    Task getTaskById(Integer taskId);

    Integer updateTask(String name, String description, String startDate, String dueDate, String label, String priority, String status, Integer id);

    List<String> getTaskUndone();

    List<HistoryTaskDTO> getHistoryTask();

    List<TaskUndoneDTO> getOverdueTask();

    Integer completeOverdueTask(Integer taskId);

    List<Date> getAllTaskDate();

    List<Task> getAllTaskList();

    Integer updateTaskStatus(Integer taskId, String status);
}
