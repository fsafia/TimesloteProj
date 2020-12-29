package com.example.examplewebwrojectnail.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class Role {
    @Column
    private Integer id;
    @Column
    private String role;
}
