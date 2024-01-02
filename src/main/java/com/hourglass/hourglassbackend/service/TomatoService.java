package com.hourglass.hourglassbackend.service;

import com.hourglass.hourglassbackend.entity.Tomato;

import java.util.List;

public interface TomatoService {
    List<Tomato> getTomatoList();

    Integer getTodayCount();

    Integer getTotalCount();

    Integer getTodayTime();

    Integer getTotalTime();

    Integer createTomato(String name, String description, Integer duration, Integer status);
}
