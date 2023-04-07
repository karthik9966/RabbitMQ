package com.ttu.RabbitMQ.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQconfig {

    @Value("${spring.queue.name}")
    private String queue;

    @Value("${spring.exchange.name}")
    private String exchange;

    @Value("${spring.routingKey.name}")
    private String routingKey;

    @Bean
    public Queue queue()
    {
        return new Queue(queue);
    }

    @Bean
    public DirectExchange exchange()
    {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding()
    {
        return  BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
    }

    @Bean
    public MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
