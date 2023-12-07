package com.hourglass.hourglassbackend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Tomato {
    private Integer id;
    private Integer userId;
    private Integer taskId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
