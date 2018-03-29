package com.dubovskyi.mongo.config;


import com.dubovskyi.mongo.domain.TwitterDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableKafka
public class KafkaConfig {

//    @Bean
//    public ConsumerFactory<String, TwitterDto> notificationsconsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//
//        // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,  "localhost:9092");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
//
//
//        return new DefaultKafkaConsumerFactory<>(props,new StringDeserializer(), new JsonDeserializer<>(TwitterDto.class));
//    }
//
//    @Bean("listener")
//    public ConcurrentKafkaListenerContainerFactory<String, TwitterDto> kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, TwitterDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(notificationsconsumerFactory());
//
//        return factory;
//    }


}
