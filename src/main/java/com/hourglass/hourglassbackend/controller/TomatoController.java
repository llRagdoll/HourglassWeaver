package com.hourglass.hourglassbackend.controller;

import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.entity.Tomato;
import com.hourglass.hourglassbackend.service.TomatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InsufficientResourcesException;
import java.util.List;

@RestController
@RequestMapping("/tomato")
public class TomatoController {

    @Autowired
    private TomatoService tomatoService;
    @PostMapping("/createTomato")
    public Result createTomato(String name,String description,Integer duration,Integer status){
        Integer code=tomatoService.createTomato(name,description,duration,status);
        if(code==0){
            return Result.error("创建番茄失败");
        }
        else{
            return Result.success();
        }
    }

    @GetMapping("/getTomatoList")
    public Result getTomatoList(){
        List<Tomato> tomatoList=tomatoService.getTomatoList();
        if(tomatoList==null){
            return Result.error("获取番茄列表失败");
        }
        else{
            return Result.success(tomatoList);
        }
    }

    @GetMapping("/getTodayCount")
    public Result getTodayCount(){
        Integer todayCount=tomatoService.getTodayCount();
        if(todayCount==null){
            return Result.error("获取今日番茄数失败");
        }
        else{
            return Result.success(todayCount);
        }

    }

    @GetMapping("/getTotalCount")
    public Result getTotalCount(){
        Integer totalCount=tomatoService.getTotalCount();
        if(totalCount==null){
            return Result.error("获取总番茄数失败");
        }
        else{
            return Result.success(totalCount);
        }

    }

    @GetMapping("/getTodayTime")
    public Result getTodayTime(){
        Integer todayTime=tomatoService.getTodayTime();
        if(todayTime==null){
            return Result.error("获取今日番茄时间失败");
        }
        else{
            return Result.success(todayTime);
        }
    }

    @GetMapping("/getTotalTime")
    public Result getTotalTime(){
        Integer totalTime=tomatoService.getTotalTime();
        if(totalTime==null){
            return Result.error("获取总番茄时间失败");
        }
        else{
            return Result.success(totalTime);
        }
    }



}
