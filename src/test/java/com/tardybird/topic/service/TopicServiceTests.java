//package com.tardybird.topic.service;
//
//import com.tardybird.topic.domain.Topic;
//import com.tardybird.topic.po.TopicPo;
//import com.tardybird.topic.service.impl.TopicServiceImpl;
//import com.tardybird.topic.util.ObjectConversion;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class TopicServiceTests {
//
//    @Autowired
//    TopicServiceImpl topicService;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void createTopic() {
//        TopicPo topicPo = new TopicPo();
//        topicPo.setPicUrlList("https://i2.cdn.turner.com/money/dam/assets/131004085738-ana28-dicks-sporting-goods-780x439.jpg");
//        topicPo.setContent("This is new topic.");
//
//        Topic topic = ObjectConversion.topicPo2Topic(topicPo);
//        topicService.addTopic(topic);
//    }
//
//    @Test
//    void updateTopic() {
//        TopicPo topicPo = new TopicPo();
//        topicPo.setId(3);
//        topicPo.setContent("This is NEW content.");
//
//        Topic topic = ObjectConversion.topicPo2Topic(topicPo);
//        topicService.updateTopic(topic);
//    }
//
//    @Test
//    void deleteTopic() {
//        topicService.deleteTopic(1);
//    }
//
//
//}
//
