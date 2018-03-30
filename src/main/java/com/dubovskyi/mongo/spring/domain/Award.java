package com.dubovskyi.mongo.spring.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Award {
    private int wins;
}
