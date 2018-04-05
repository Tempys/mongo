package com.dubovskyi.mongo.spring.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "students")
public class Students {

    @Id
   private String id;
   List<StudentScore> scores;
}
