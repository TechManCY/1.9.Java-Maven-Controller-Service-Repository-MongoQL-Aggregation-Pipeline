package com.example.mongo_aggregation_pipeline.controller;

import com.example.mongo_aggregation_pipeline.model.StudentWrapper;
import com.example.mongo_aggregation_pipeline.service.StudentAggregation;
import com.example.mongo_aggregation_pipeline.service.StudentWrapperService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/studentWrapper")
@RequiredArgsConstructor
public class StudentWrapperController {

    private final StudentWrapperService studentWrapperService;
    private final StudentAggregation studentAggregation;

    @GetMapping("/get")
    public ResponseEntity<List<StudentWrapper>> getAllStudentWrapper(){
        return ResponseEntity.ok(studentWrapperService.getAllStudentWrapper());
    }

    @PostMapping("/create")
    public ResponseEntity<StudentWrapper> createStudentWrapper(@RequestBody StudentWrapper studentWrapper){
        return ResponseEntity.ok(studentWrapperService.createStudentWrapper(studentWrapper));
    }

    @GetMapping("/chartData")
    public ResponseEntity<List<Document>> getChartData(){
        return new ResponseEntity<>(studentAggregation.getStudentClassTimeAggregation(), HttpStatus.OK);
    }

}
