package com.example.schedules_planner.controller;

import com.example.schedules_planner.dto.SchedulesRequestDto;
import com.example.schedules_planner.dto.SchedulesResponseDto;
import com.example.schedules_planner.entity.Schedules;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class SchedulesController {
    // RestController
    // @Controller -> return "admin"; -> admin.html -> JSP, Thymleaf -> Front 작업할 수 있는 스프링 같은
    // @RestController -> return ResponseEntity -> html 같은 페이지로 리턴을 하는건 아니잖아요? -> json 형식

    // 생성자
    // Calculator cal = new Calculator(); -> 객체를 생성한다. -> 생성자를 호출한다.
    // calculate(); -> 함수 -> 어딘가 정의되어 있어야 하죠?
    private final Map<Long, Schedules> schedulesList = new HashMap<>();

    @PostMapping
    public ResponseEntity<SchedulesResponseDto> createSchedules(@RequestBody SchedulesResponseDto dto){
        // 식별자가 1씩 증가 하도록 만든다.
        Long schedulesId = schedulesList.isEmpty() ? 1 : Collections.max(schedulesList.keySet()) + 1;

        // 요청받은 데이터로 Schedules 객체 생성
        Schedules schedules = new Schedules(schedulesId,dto.getName(), dto.getPassword(), dto.getCreationDate(), dto.getModificationDate(), dto.getTodo());

        // Inmemory DB에 저장
        schedulesList.put(schedulesId, schedules);

        return new ResponseEntity<>(new SchedulesResponseDto(schedules), HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<SchedulesResponseDto>> findAllSchedules() {
        // init List
        List<SchedulesResponseDto> responseList = new ArrayList<>();

        // HashMap<Memo> -> List<MemoResponseDto>
        for (Schedules schedules : schedulesList.values()) {
            SchedulesResponseDto responseDto = new SchedulesResponseDto(schedules);
            responseList.add(responseDto);
        }

        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }



    // 일정 선택 조회
    @GetMapping("/{id}")
    public ResponseEntity<SchedulesResponseDto> findSchedulesById(@PathVariable Long id) {

        // 식별자의 Memo가 없다면?
        Schedules schedules = schedulesList.get(id);

        // NPE 방지
        if (schedules == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new SchedulesResponseDto(schedules), HttpStatus.OK);
    }


    // 일정 선택 수정
    @PutMapping("/{id}")
    public ResponseEntity<SchedulesResponseDto> updateSchedulesById(
            @PathVariable Long id,
            @RequestBody SchedulesRequestDto dto
    ) {
        Schedules schedules = schedulesList.get(id);

        // NPE 방지
        if (schedules == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new SchedulesResponseDto(schedules), HttpStatus.OK);
    }



    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> schedulesDelete(@PathVariable Long id, @RequestBody SchedulesResponseDto dto) {
        if (!schedulesList.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        schedulesList.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
