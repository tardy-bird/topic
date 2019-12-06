package com.tardybird.topic.service.impl;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.mapper.TopicMapper;
import com.tardybird.topic.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * @author nick
 */
@Service
public class TopicServiceImpl implements TopicService {

    private final
    TopicMapper topicMapper;

    public TopicServiceImpl(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    @Override
    public Topic getTopicDetail(Integer id) {
        return topicMapper.getTopicDetail(id);
    }

    @Override
    public void addTopic(Topic topic) {
        topicMapper.addTopic(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        topicMapper.updateTopic(topic);
    }

    @Override
    public void deleteTopic(Topic topic) {
        topicMapper.deleteTopic(topic);
    }

}
