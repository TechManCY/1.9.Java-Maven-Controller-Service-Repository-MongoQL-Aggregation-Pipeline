package com.example.mongo_aggregation_pipeline.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
    private List<Long> classIds;
    private Double gpa;

}
