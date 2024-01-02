package com.hourglass.hourglassbackend.controller;

import com.hourglass.hourglassbackend.dto.TaskDistributionDTO;
import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.entity.User;
import com.hourglass.hourglassbackend.service.UserService;
import com.hourglass.hourglassbackend.utils.JwtUtil;
import com.hourglass.hourglassbackend.utils.Md5Util;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public Result register(@Pattern(regexp="^\\S{3,16}$")String username, String password){
        User u=userService.getUserByName(username);
        if(u!=null){
            return Result.error("用户名已存在");
        }
        else{
            userService.register(username,password);
            return Result.success();
        }
    }

    @PostMapping("/login")
public Result login(@Pattern(regexp="^\\S{3,16}$")String username, String password){
        User u=userService.getUserByName(username);
        if(u==null){
            return Result.error("用户名不存在");
        }
        else{
            if(Md5Util.getMD5String(password).equals(u.getPassword())){
                Map<String,Object> claims=new HashMap<>();
                claims.put("id",u.getId());
                claims.put("name",u.getName());
                String token= JwtUtil.genToken(claims);
                return Result.success(token);
            }
            else{
                return Result.error("密码错误");
            }
        }
    }

    @GetMapping("/getUserInfo")
    public Result<User> userInfo(){
        Map<String,Object> map=ThreadLocalUtil.get();
        String username=(String)map.get("name");
        User u=userService.getUserByName(username);
        return Result.success(u);
    }

    @PostMapping("/updateUserInfo")
    public Result update(String name,String email,String phone,String avatar){
        System.out.println(name);
        System.out.println(email);
        System.out.println(phone);
        userService.update(name,email,phone,avatar);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }


    @GetMapping("/getTaskDistribution")
    public Result getTaskDistribution(){
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("id");
        System.out.println(userId);
        TaskDistributionDTO taskDistributionDTO=userService.getTaskDistribution(userId);
        System.out.println(taskDistributionDTO);
        return Result.success(taskDistributionDTO);
    }


    @GetMapping("/getRecentTask")
    public Result getRecentTask(Integer userId){
        return Result.success(userService.getRecentTask(userId));
    }



}

