package com.dubovskyi.mongo;


import com.dubovskyi.mongo.domain.Payload;
import com.dubovskyi.mongo.domain.TwitterDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
public class TwitterListener {


    @KafkaListener(topics ="demo-3-twitter")
    public void receive(String dto) throws InterruptedException {
        System.out.println("te   "+ dto);


        TwitterDto item =  new Gson().fromJson(dto,TwitterDto.class);
        System.out.println("item: "+item);

        Thread.sleep(1000L);
    }
}
