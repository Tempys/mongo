package com.dubovskyi.mongo.spring.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "grades")
public class Student {
    @Id
    private String id;

    private Integer studentId;

    private String type;

    private Double score;


}
