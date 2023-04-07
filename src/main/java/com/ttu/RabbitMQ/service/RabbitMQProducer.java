package com.ttu.RabbitMQ.service;

import com.ttu.RabbitMQ.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

@Service
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.exchange.name}")
    private String exchange;

    @Value("${spring.routingKey.name}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    public void sendMessage(UserDto userDto)
    {
        LOGGER.info(userDto.toString());
        byte[] body = SerializationUtils.serialize(userDto);
        Message message = MessageBuilder.withBody(body).build();
        rabbitTemplate.send(exchange,routingKey,message);
    }

}
