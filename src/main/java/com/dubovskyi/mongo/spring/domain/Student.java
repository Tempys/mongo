package com.dubovskyi.mongo.spring.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "grades")
public class Student {
    @Id
    private String id;

    @Field("student_id")
    private Integer studentId;

    private String type;

    private Double score;


}
