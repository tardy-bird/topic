package com.tardybird.topic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.mapper.TopicMapper;
import com.tardybird.topic.po.TopicPo;
import com.tardybird.topic.service.TopicService;
import com.tardybird.topic.util.Converter;
import com.tardybird.topic.util.TopicConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 */
@Service
public class TopicServiceImpl implements TopicService {

    final TopicMapper topicMapper;

    final Converter<TopicPo, Topic> topicConverter = new TopicConverter();

    public TopicServiceImpl(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    @Override
    public Topic getTopicDetail(Integer id) {
        TopicPo topicPo = topicMapper.getTopicDetail(id);

        if (topicPo == null) {
            return null;
        }

        Topic topic = topicConverter.converterFromPo(topicPo);

        // 图片URL已经隐含在picUrlList中
        topic.setPictures(null);

        return topic;
    }

    @Override
    public Object getTopics(Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<TopicPo> topicPos = topicMapper.getTopics();

        if (topicPos == null) {
            return null;
        }

        List<Topic> topics = new ArrayList<>();

        for (TopicPo topicPo : topicPos) {

            Topic topic = topicConverter.converterFromPo(topicPo);

            // 直接解析picUrlList，不需要转成URL列表
            topic.setPictures(null);

            topics.add(topic);
        }

        return new PageInfo<>(topics);
    }

    @Override
    public Topic addTopic(TopicPo topicPo) {
        topicMapper.addTopic(topicPo);
        Integer id = topicPo.getId();
        TopicPo po = topicMapper.getTopicDetail(id);
        return topicConverter.converterFromPo(po);
    }

    @Override
    public TopicPo updateTopic(TopicPo topicPo) {
        topicMapper.updateTopic(topicPo);
        Integer id = topicPo.getId();
        topicPo = topicMapper.getTopicDetail(id);
        return topicPo;
    }

    @Override
    public void deleteTopic(Integer id) {
        topicMapper.deleteTopic(id);
    }

}
