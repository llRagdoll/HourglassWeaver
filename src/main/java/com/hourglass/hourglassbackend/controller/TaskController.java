package com.hourglass.hourglassbackend.controller;

import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.entity.Task;
import com.hourglass.hourglassbackend.service.TaskService;
import com.hourglass.hourglassbackend.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("hello");
    }

    @PostMapping("/add")
    public Result add(@RequestBody Task task) {
        taskService.add(task);
        return Result.success("hello");
    }
}
