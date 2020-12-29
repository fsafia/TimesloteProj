package com.example.examplewebwrojectnail.model.service;


import com.example.examplewebwrojectnail.model.entity.TimeSlote;
import com.example.examplewebwrojectnail.model.repository.TimeSloteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.time.Month;

import static java.time.LocalDate.of;


@Service
public class TimeSloteService {

    private TimeSloteRepository timeSloteRepository;

    public TimeSloteService(TimeSloteRepository timeSloteRepository) {
        this.timeSloteRepository = timeSloteRepository;
    }

    public TimeSlote getTimeSlotById(Integer id) {
        return timeSloteRepository.findTimeSloteById(id);
    }

    @Transactional
    public ResponseEntity<TimeSlote> addTimeSlote(TimeSlote timeSlote) {

        try {
            TimeSlote timeSlote1 = TimeSlote.builder()
                    .date(of(2020, Month.DECEMBER,28 ))
                    .capacity(timeSlote.getCapacity())
                    .timeSince(LocalTime.of(9,0,0))
                    .timeEnd(LocalTime.of(12,0,0))
                    .isActive(timeSlote.isActive())
                    .recomended(timeSlote.isRecomended())
                    .build();
            timeSloteRepository.save(timeSlote);
            return new ResponseEntity<TimeSlote>(timeSlote1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
        }

    }
}
