package com.tardybird.topic.util;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.po.TopicPo;

import java.util.function.Function;

/**
 * @author nick
 */
public class TopicConverter extends Converter<TopicPo, Topic> {

    public TopicConverter() {
        super(new TopicPoFunction(), new TopicFunction());
    }

    static class TopicPoFunction implements Function<TopicPo, Topic> {
        /**
         * Applies this function to the given argument.
         *
         * @param topicPo the function argument
         * @return the function result
         */
        @Override
        public Topic apply(TopicPo topicPo) {

            if (topicPo == null) {
                return null;
            }

            Topic topic = new Topic();
            topic.setId(topicPo.getId());
            topic.setGmtCreate(topicPo.getGmtCreate());
            topic.setGmtModified(topicPo.getGmtModified());
            topic.setBeDeleted(topicPo.getBeDeleted());
            topic.setPicUrlList(topicPo.getPicUrlList());
            topic.setContent(topicPo.getContent());

            return topic;
        }
    }

    static class TopicFunction implements Function<Topic, TopicPo> {
        /**
         * Applies this function to the given argument.
         *
         * @param topic the function argument
         * @return the function result
         */
        @Override
        public TopicPo apply(Topic topic) {

            if (topic == null) {
                return null;
            }

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
}
