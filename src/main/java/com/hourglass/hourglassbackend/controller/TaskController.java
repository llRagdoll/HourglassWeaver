package com.hourglass.hourglassbackend.controller;

import com.hourglass.hourglassbackend.dto.HistoryTaskDTO;
import com.hourglass.hourglassbackend.dto.TaskUndoneDTO;
import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.entity.Task;
import com.hourglass.hourglassbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping("/getTaskList")
    public Result getTaskList() {
        List<Task> tasks=taskService.getTaskList();
        if(tasks==null){
            return Result.error("获取任务列表失败");
        }
        else{
            return Result.success(tasks);
        }
    }

    @GetMapping("/getAllTaskList")
    public Result getAllTaskList() {
        List<Task> tasks=taskService.getAllTaskList();
        if(tasks==null){
            return Result.error("获取任务列表失败");
        }
        else{
            return Result.success(tasks);
        }
    }

    @GetMapping("/getTaskById")
    public Result getTask(Integer taskId) {
        System.out.println(taskId);
        Task task= taskService.getTaskById(taskId);
        System.out.println(task);
        return Result.success(task);
    }

    @PostMapping("/createTask")
    public Result add(Task task) {
        taskService.createTask(task);
        return Result.success();
    }

    @PostMapping("/deleteTask")
    public Result delete(Integer taskId) {
        System.out.println(taskId);
        Integer code=taskService.deleteTask(taskId);
        System.out.println(code);
        if(code==0){
            return Result.error("删除任务失败");
        }
        else{
            return Result.success("删除任务成功");
        }
    }

    @PostMapping("/updateTask")
    public Result update(String name,  String description,  String startDate,  String dueDate,  String label,  String priority,  String status,  Integer id) {
        Integer code=taskService.updateTask(name,description,startDate,dueDate,label,priority,status,id);
        if(code==0){
            return Result.error("更新任务失败");
        }
        else{
            return Result.success("更新任务成功");
        }
    }

    @GetMapping("/getHistoryTask")
    public Result getHistoryTask() {
        List<HistoryTaskDTO> tasks=taskService.getHistoryTask();
        if(tasks==null){
            return Result.error("获取历史任务列表失败");
        }
        else{
            return Result.success(tasks);
        }

    }

    @GetMapping("/getOverdueTask")
    public Result getOverdueTask() {
        List<TaskUndoneDTO> tasks=taskService.getOverdueTask();
        if(tasks==null){
            return Result.error("获取过期任务列表失败");
        }
        else{
            return Result.success(tasks);
        }

    }

    @PostMapping("/submitTask")
    public void submitTask() {

    }

    @GetMapping("/getTaskUndone")
    public Result getTaskUndone() {
        List<String> tasks=taskService.getTaskUndone();
        if(tasks==null){
            return Result.error("获取任务列表失败");
        }
        else{
            return Result.success(tasks);
        }
    }

    @PostMapping("/completeOverdueTask")
    public Result completeOverdueTask(Integer taskId) {
        Integer code=taskService.completeOverdueTask(taskId);
        if(code==0){
            return Result.error("完成过期任务失败");
        }
        else{
            return Result.success("完成过期任务成功");
        }
    }

    @GetMapping("/getAllTaskDate")
    public Result getAllTaskDate() {
        List<Date> tasks=taskService.getAllTaskDate();
        if(tasks==null){
            return Result.error("获取任务列表失败");
        }
        else{
            return Result.success(tasks);
        }
    }

    @PostMapping("/updateTaskStatus")
    public Result updateTaskStatus(Integer taskId,String status) {
        Integer code=taskService.updateTaskStatus(taskId,status);
        if(code==0){
            return Result.error("更新任务状态失败");
        }
        else{
            return Result.success("更新任务状态成功");
        }
    }

}
