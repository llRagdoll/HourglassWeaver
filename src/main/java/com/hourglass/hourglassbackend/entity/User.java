package com.hourglass.hourglassbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    @NotNull
    private Integer id;

    @NotEmpty
    private String name;

    private String email;

    private String phone;

    @JsonIgnore
    private String password;

    private String avatar;

    private LocalDateTime createdTime;

    public User() {
    }


}
