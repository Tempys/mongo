package com.dubovskyi.mongo.spring.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class StudentDto {

   // @Field("_id")
    @Id  Integer   studentId;
    private String root_id;
    private Double score;
    private String type;
}
