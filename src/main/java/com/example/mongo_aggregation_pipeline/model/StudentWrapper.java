package com.example.mongo_aggregation_pipeline.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.mongo_aggregation_pipeline.model.Class;

import java.util.List;

@Document(collection = "student_wrappers_extend")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentWrapper {
    @Id
    private String id;
    private Student student;
    private List<Class> classes;

}
