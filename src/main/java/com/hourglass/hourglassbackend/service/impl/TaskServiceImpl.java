package com.hourglass.hourglassbackend.service.impl;

import com.hourglass.hourglassbackend.dto.HistoryTaskDTO;
import com.hourglass.hourglassbackend.dto.TaskUndoneDTO;
import com.hourglass.hourglassbackend.entity.Task;
import com.hourglass.hourglassbackend.mapper.TaskMapper;
import com.hourglass.hourglassbackend.service.TaskService;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void createTask(Task task){
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        task.setUserId(userId);
        taskMapper.add(task);
    }

    @Override
    public Integer updateTask(String name, String description, String startDate, String dueDate, String label, String priority, String status, Integer id){

        return taskMapper.update(name, description, startDate, dueDate, label, priority, status, id);
    }

    @Override
    public Integer deleteTask(Integer taskId) {
        return taskMapper.delete(taskId);
    }

    @Override
    public List<Task> getTaskList() {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.getTaskList(id);
    }

    @Override
    public Task getTaskById(Integer taskId) {
        return taskMapper.getTaskById(taskId);
    }


    @Override
    public List<String> getTaskUndone() {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.getTaskUndone(id);
    }

    @Override
    public List<HistoryTaskDTO> getHistoryTask() {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.getHistoryTask(id);
    }

    @Override
    public List<TaskUndoneDTO> getOverdueTask() {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.getOverdueTask(id);
    }

    @Override
    public Integer completeOverdueTask(Integer taskId) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.completeOverdueTask(id,taskId);
    }

    @Override
    public List<Date> getAllTaskDate() {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.getAllTaskDate(id);
    }

    @Override
    public List<Task> getAllTaskList() {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return taskMapper.getAllTaskList(id);
    }

    @Override
    public Integer updateTaskStatus(Integer taskId, String status) {
        return taskMapper.updateTaskStatus(taskId, status);
    }
}
