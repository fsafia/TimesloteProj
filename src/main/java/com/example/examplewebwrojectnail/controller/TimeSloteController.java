package com.example.examplewebwrojectnail.controller;

import com.example.examplewebwrojectnail.model.entity.TimeSlote;
import com.example.examplewebwrojectnail.model.service.TimeSloteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timeslote")
public class TimeSloteController {

    private TimeSloteService timeSloteService;

    public TimeSloteController(TimeSloteService timeSloteService) {
        this.timeSloteService = timeSloteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlote> getTimeSlotById(@PathVariable(name = "id") Integer id) {
        TimeSlote timeSlote = timeSloteService.getTimeSlotById(id);
        return new ResponseEntity<TimeSlote>(timeSlote, HttpStatus.OK);
    }

    @GetMapping("/reservTimeSlot/id")
    public ResponseEntity<TimeSlote> reservTimeSlot(@RequestParam(name = "id") Integer id) {
        TimeSlote timeSlote = timeSloteService.getTimeSlotById(id).builder()
                .isActive(false)
                .build(); //не создастся новая строчка в БД, т.к. над методом getTimeSlotById нет анотации @Transactional?
        //просто получим объект у которого утсановили поле isActive(false)
        return new ResponseEntity<TimeSlote>((TimeSlote)null, HttpStatus.CREATED );
    }

    @PostMapping("/add")
    public ResponseEntity<TimeSlote> addTimeSlote(TimeSlote timeSlote) {
        return timeSloteService.addTimeSlote(timeSlote);

    }
}
