package com.hourglass.hourglassbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryTaskDTO {
    private String name;
    private String priority;
    private String status;
    private Date dueDate;
    private Date startDate;

}
