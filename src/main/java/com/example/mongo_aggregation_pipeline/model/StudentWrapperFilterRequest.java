package com.example.mongo_aggregation_pipeline.model;

import lombok.Data;

@Data
public class StudentWrapperFilterRequest {
    private StudentWrapperSearchCriteria searchCriteria;
    private StudentWrapperPage page;
}
