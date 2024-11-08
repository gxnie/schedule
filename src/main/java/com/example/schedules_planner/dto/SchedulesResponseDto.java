package com.example.schedules_planner.dto;

import com.example.schedules_planner.entity.Schedules;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulesResponseDto {

    private Long id;
    private String name;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private String todo;

    public SchedulesResponseDto() {}

    public SchedulesResponseDto(Schedules schedules){
        this.id = schedules.getId();
        this.name = schedules.getName();
        this.password = schedules.getPassword();
        this.creationDate = schedules.getCreationDate();
        this.modificationDate = schedules.getModificationDate();
        this.todo = schedules.getTodo();

    }
}
