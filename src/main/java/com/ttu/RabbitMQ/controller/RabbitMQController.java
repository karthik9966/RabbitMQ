package com.ttu.RabbitMQ.controller;

import com.ttu.RabbitMQ.dto.UserDto;
import com.ttu.RabbitMQ.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/rabbit")
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @PostMapping
    public byte[] postUser(@RequestBody UserDto userDto)
    {
        return rabbitMQProducer.sendMessage(userDto);
    }
}
