package com.tardybird.topic.service;

import com.tardybird.topic.domain.Topic;

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
     * add topic
     *
     * @param topic object
     */
    void addTopic(Topic topic);

    /**
     * xxx
     *
     * @param topic topic object
     */
    void updateTopic(Topic topic);

    /**
     * xxx
     *
     * @param topic topic object
     */
    void deleteTopic(Topic topic);
}
