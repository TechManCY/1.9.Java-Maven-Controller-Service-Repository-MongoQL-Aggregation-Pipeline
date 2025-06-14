package com.example.mongo_aggregation_pipeline.service;

import com.example.mongo_aggregation_pipeline.model.StudentWrapper;
import com.example.mongo_aggregation_pipeline.repository.StudentWrapperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentWrapperService {

    private final StudentWrapperRepository studentWrapperRepository;

    public List<StudentWrapper> getAllStudentWrapper() {
        return studentWrapperRepository.findAll();
    }

    public StudentWrapper createStudentWrapper(StudentWrapper studentWrapper) {
        return studentWrapperRepository.save(studentWrapper);
    }
}
