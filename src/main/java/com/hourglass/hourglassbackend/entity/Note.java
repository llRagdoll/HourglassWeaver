package com.hourglass.hourglassbackend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Note {
    private Integer id;
    private Integer userId;
    private String title;
    private String text;
    private String tag;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
