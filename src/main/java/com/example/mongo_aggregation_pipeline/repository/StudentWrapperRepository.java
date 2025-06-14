package com.example.mongo_aggregation_pipeline.repository;

import com.example.mongo_aggregation_pipeline.model.StudentWrapper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentWrapperRepository extends MongoRepository <StudentWrapper,String> {
}
