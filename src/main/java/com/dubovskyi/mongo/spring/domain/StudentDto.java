package com.dubovskyi.mongo.spring.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class StudentDto {

   // @Field("_id")
   @Id  String studentId;
    private String root_id;
    private Double score;
    private String type;
}
