package com.tardybird.topic.service;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.po.TopicPo;

/**
 * @author nick
 */
public interface TopicService {

    /**
     * 获取专题详情
     *
     * @param id 专题ID
     * @return a topic
     */
    Topic getTopicDetail(Integer id);

    /**
     * 获取专题列表
     *
     * @param page  页数
     * @param limit 每一页的最大数量
     * @return Topic列表
     */
    Object getTopics(Integer page, Integer limit);

    /**
     * 新建专题
     *
     * @param topicPo TopicPo
     * @return TopicPo
     */
    Topic addTopic(TopicPo topicPo);

    /**
     * 更新专题
     *
     * @param topicPo TopicPo
     * @return TopicPo
     */
    TopicPo updateTopic(TopicPo topicPo);

    /**
     * 删除专题
     *
     * @param id 专题ID
     */
    void deleteTopic(Integer id);

}
