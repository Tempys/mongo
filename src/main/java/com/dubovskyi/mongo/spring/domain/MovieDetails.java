package com.dubovskyi.mongo.spring.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movieDetails")
public class MovieDetails {

    @Id
    private String id;
    private int year;
    private String rated;
    private String title;
    private Award awards;

}
