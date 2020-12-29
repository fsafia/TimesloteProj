package com.example.examplewebwrojectnail.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "timeslotes")
@Builder
public class TimeSlote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate date;

    @Column
    private int capacity;

    @Column
    private LocalTime timeSince;


    @Column
    private LocalTime timeEnd;

    @Column
    private boolean isActive;

    @Column
    private boolean recomended;
}
