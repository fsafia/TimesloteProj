package com.example.examplewebwrojectnail.model.repository;

import com.example.examplewebwrojectnail.model.entity.TimeSlote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSloteRepository extends JpaRepository<TimeSlote, Integer> {

    public TimeSlote findTimeSloteById(Integer id);
}
