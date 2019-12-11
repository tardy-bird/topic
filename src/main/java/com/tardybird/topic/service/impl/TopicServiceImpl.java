package com.tardybird.topic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.mapper.TopicMapper;
import com.tardybird.topic.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Object getTopics(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Topic> topics = topicMapper.getTopics();
        return new PageInfo<>(topics);
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
