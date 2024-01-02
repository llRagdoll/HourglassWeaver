package com.hourglass.hourglassbackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteDTO {
    private Integer id;
    private String title;
    private String tag;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
