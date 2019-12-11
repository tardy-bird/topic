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
