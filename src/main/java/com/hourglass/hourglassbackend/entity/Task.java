package com.hourglass.hourglassbackend.entity;

import lombok.Data;

@Data
public class Task {
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private String status;
    private String priority;
    private String label;
    private String dueDate;
    private String startDate;
}
