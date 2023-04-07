package com.ttu.RabbitMQ.service;

import com.ttu.RabbitMQ.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${spring.queue.name}")
    public void consumeMessage(UserDto userDto)
    {
        LOGGER.info(userDto.toString());
    }
}
