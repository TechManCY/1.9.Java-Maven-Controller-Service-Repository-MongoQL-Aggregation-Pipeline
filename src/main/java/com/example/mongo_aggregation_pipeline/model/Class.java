package com.example.mongo_aggregation_pipeline.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Class {
    private Long classId;
    private String subjectName;
    private LocalDateTime startDate;
    private Double hoursTutorial;
    private Double hoursLesson;

}
