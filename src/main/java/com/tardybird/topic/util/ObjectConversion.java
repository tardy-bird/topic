package com.tardybird.topic.util;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.po.TopicPo;

/**
 * @author nick
 */
public class ObjectConversion {

    public static Topic topicPo2Topic(TopicPo topicPo) {
        Topic topic = new Topic();

        topic.setId(topicPo.getId());
        topic.setGmtCreate(topicPo.getGmtCreate());
        topic.setGmtModified(topicPo.getGmtModified());
        topic.setBeDeleted(topicPo.getBeDeleted());
        topic.setPicUrlList(topicPo.getPicUrlList());
        topic.setContent(topicPo.getContent());

        return topic;
    }

    public static TopicPo topic2TopicPo(Topic topic) {
        TopicPo topicPo = new TopicPo();

        topicPo.setId(topic.getId());
        topicPo.setGmtCreate(topic.getGmtCreate());
        topicPo.setGmtModified(topic.getGmtModified());
        topicPo.setBeDeleted(topic.getBeDeleted());
        topicPo.setPicUrlList(topic.getPicUrlList());
        topicPo.setContent(topic.getContent());

        return topicPo;
    }
}
