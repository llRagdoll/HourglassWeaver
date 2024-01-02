package com.hourglass.hourglassbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RecentTaskDTO {
    private String name;
    private String priority;
    private String status;
    private Date dueDate;

}
