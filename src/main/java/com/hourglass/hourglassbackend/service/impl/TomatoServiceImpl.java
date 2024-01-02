package com.hourglass.hourglassbackend.service.impl;

import com.hourglass.hourglassbackend.entity.Tomato;
import com.hourglass.hourglassbackend.mapper.TomatoMapper;
import com.hourglass.hourglassbackend.service.TomatoService;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TomatoServiceImpl implements TomatoService {
    @Autowired
    private TomatoMapper tomatoMapper;
    @Override
    public List<Tomato> getTomatoList() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return tomatoMapper.getTomatoList(id);
    }

    @Override
    public Integer getTodayCount() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return tomatoMapper.getTodayCount(id);
    }

    @Override
    public Integer getTotalCount() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return tomatoMapper.getTotalCount(id);
    }

    @Override
    public Integer getTodayTime() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return tomatoMapper.getTodayTime(id);
    }

    @Override
    public Integer getTotalTime() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return tomatoMapper.getTotalTime(id);
    }

    @Override
    public Integer createTomato(String name, String description, Integer duration, Integer status) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return tomatoMapper.createTomato(name,description,duration,status,id);
    }
}
