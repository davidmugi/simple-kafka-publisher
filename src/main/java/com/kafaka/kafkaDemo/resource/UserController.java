package com.kafaka.kafkaDemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserController {

    @Autowired
    private KafkaTemplate<String, Users> KafkaTemplate;

    private static final String Topic = "UserExample2";

    @GetMapping("/user/{name}")
    public String getUser(@PathVariable("name") String name){

        Users users = new Users(name,"23",2000L);

        KafkaTemplate.send(Topic,users);
        return "sent";
    }
    
}