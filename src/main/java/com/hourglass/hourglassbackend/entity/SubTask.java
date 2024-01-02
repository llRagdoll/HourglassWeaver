package com.hourglass.hourglassbackend.entity;

import lombok.Data;

@Data
public class SubTask {
    private Integer id;
    private Integer taskId;
    private String name;
}
