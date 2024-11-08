package com.example.schedules_planner.entity;

import com.example.schedules_planner.dto.SchedulesRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 생성하기!
public class Schedules {
    private Long id;
    private String name;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private String todo;

    public void update(SchedulesRequestDto requestDto) {
        this.name = requestDto.getName();
        this.todo = requestDto.getTodo();


//        LocalDateTime dateTime = LocalDateTime.now();
//        // 포맷 지정하기 "yyyy-MM-dd HH:mm:ss"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        String stringFormatter = dateTime.format(formatter);
//        this.modificationDate = stringFormatter;
    }
}
