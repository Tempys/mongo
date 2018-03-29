package com.dubovskyi.mongo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

//@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {


        SpringApplication.run(MongoApplication.class, args);
    }

}
