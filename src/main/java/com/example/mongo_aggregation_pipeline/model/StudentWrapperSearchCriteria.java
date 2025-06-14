package com.example.mongo_aggregation_pipeline.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StudentWrapperSearchCriteria {
    //within class
    private Long classId; //exact match
    private String subjectName; //partial match
    private LocalDateTime minStartDate; //range search
    private LocalDateTime maxStartDate; //range search

    //within student
    private Long studentId;  //exact match
    private String firstName; //partial match
    private String lastName; //partial match
    private List<Long> classIds; // filter by multiple class IDs

}
