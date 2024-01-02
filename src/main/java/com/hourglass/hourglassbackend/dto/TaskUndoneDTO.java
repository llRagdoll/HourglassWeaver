package com.hourglass.hourglassbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskUndoneDTO {
    private String name;
    private Integer id;
    private Date dueDate;
}
