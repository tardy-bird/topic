package com.tardybird.topic.service;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.service.impl.TopicServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicServiceTests {

    @Autowired
    TopicServiceImpl topicService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        Topic topic = new Topic();
        topic.setPicUrlList("https://i2.cdn.turner.com/money/dam/assets/131004085738-ana28-dicks-sporting-goods-780x439.jpg");
        topic.setContent("This is new topic.");
        topicService.addTopic(topic);
    }

    @Test
    void delete() {
        Topic topic = new Topic();
        topic.setId(2);
        topicService.deleteTopic(topic);
    }

}

