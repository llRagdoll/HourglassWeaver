package com.hourglass.hourglassbackend.controller;


import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subtask")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping("/createSubtask")
    public Result createSubTask(String name,Integer taskId){
        Integer code=subTaskService.createSubTask(name,taskId);
        if(code==0){
            return Result.error("创建子任务失败");
        }
        else{
            return Result.success();
        }
    }

    @PostMapping("/completeSubtask")
    public Result completeSubTask(Integer subTaskId){
        System.out.println("subTaskId:");
        System.out.println(subTaskId);
        Integer code=subTaskService.completeSubTask(subTaskId);
        if(code==0){
            return Result.error("完成子任务失败");
        }
        else{
            return Result.success();
        }
    }

    @GetMapping("/getSubTaskList")
    public Result getSubTaskList(Integer taskId){
        return Result.success(subTaskService.getSubTaskList(taskId));
    }



}
