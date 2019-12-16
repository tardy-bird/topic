package com.tardybird.topic.service;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.po.TopicPo;

/**
 * @author nick
 */
public interface TopicService {

    /**
     * topic detail
     *
     * @param id topic id
     * @return a topic
     */
    Topic getTopicDetail(Integer id);

    /**
     * xx
     *
     * @param page  x
     * @param limit x
     * @return x
     */
    Object getTopics(Integer page, Integer limit);

    /**
     * add topic
     *
     * @param topicPo object
     */
    void addTopic(TopicPo topicPo);

    /**
     * xxx
     *
     * @param topicPo topic object
     */
    void updateTopic(TopicPo topicPo);

    /**
     * xxx
     *
     * @param id topic object
     */
    void deleteTopic(Integer id);
}
