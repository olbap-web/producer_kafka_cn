package com.example.producerkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String topic_senales = "senales_topic";
    private static final String topic_alertas = "alertas_topic";


    public void sendMessage(String message, int topic) {


        if(topic == 1){
            kafkaTemplate.send(topic_alertas, message);
        }
        
        if(topic == 2){
            kafkaTemplate.send(topic_senales, message);
        }

    }
}