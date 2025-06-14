package com.example.mongo_aggregation_pipeline.service;

import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentAggregation {

    private final MongoTemplate mongoTemplate;

    public List<Document> getStudentClassTimeAggregation() {

        UnwindOperation unwindClasses = Aggregation.unwind("classes", true);

        GroupOperation groupByStudentAndSubject = Aggregation.group(
                        "student.studentId", "student.firstName", "student.lastName", "classes.subjectName")
                .sum("classes.hoursTutorial").as("totalTutorialHours")
                .sum("classes.hoursLesson").as("totalLectureHours");

        GroupOperation groupByStudent = Aggregation.group("_id.studentId", "_id.firstName", "_id.lastName")
                .push(
                        new Document()
                                .append("subjectName", "$_id.subjectName")
                                .append("totalHours", new Document("$add", Arrays.asList("$totalTutorialHours", "$totalLectureHours")))
                ).as("subjects")
                .sum("totalTutorialHours").as("totalTutorialHours")
                .sum("totalLectureHours").as("totalLectureHours");

        ProjectionOperation projectFinal = Aggregation.project()
                .and("_id.studentId").as("studentId")
                //.andExpression("concat(_id.firstName, ' ', _id.lastName)").as("studentName")
                .andInclude("totalTutorialHours", "totalLectureHours", "subjects")
                .andExpression("totalTutorialHours + totalLectureHours").as("totalHours");

        Aggregation aggregation = Aggregation.newAggregation(
                unwindClasses,
                groupByStudentAndSubject,
                groupByStudent,
                projectFinal
        );

        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "student_wrappers_extend", Document.class);

        return results.getMappedResults();
    }
}