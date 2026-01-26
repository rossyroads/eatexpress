package com.eatexpress.app.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopologyConfig {

    public static final String EVENTS_EXCHANGE_TOPIC = "events-exchange-topic";

    @Bean
    TopicExchange eventsExchangeTopic() {
        return new TopicExchange(EVENTS_EXCHANGE_TOPIC);
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    public static final String DISH_CREATED_QUEUE = "dish-created-queue";
    public static final String DISH_STATUS_SET_QUEUE = "dish-status-set-queue";

    @Bean
    Queue dishCreatedQueue() {
        return new Queue(DISH_CREATED_QUEUE);
    }

    // @Bean
    // Queue dishStatusSetQueue() {
    //     return new Queue(DISH_STATUS_SET_QUEUE);
    // }

    @Bean
    Binding bindDishCreatedQueueToTopic(
        TopicExchange eventsExchangeTopic,
        Queue dishCreatedQueue
    ) {
        return BindingBuilder.bind(dishCreatedQueue)
            .to(eventsExchangeTopic)
            .with("dish.create.#");
    }

    // @Bean
    // Binding bindDishStatusSetQueueToTopic(
    //     TopicExchange eventsExchangeTopic,
    //     Queue dishStatusSetQueue
    // ) {
    //     return BindingBuilder.bind(dishStatusSetQueue)
    //         .to(eventsExchangeTopic)
    //         .with("dish.status.*");
    // }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
