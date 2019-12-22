package com.tardybird.topic.mapper;

import com.tardybird.topic.po.TopicPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nick
 */
@Component
@Mapper
@Repository
public interface TopicMapper {

    /**
     * 获取专题详情
     *
     * @param id 专题ID
     * @return a topic
     */
    TopicPo getTopicDetail(Integer id);

    /**
     * 获取专题列表
     *
     * @return Topic列表
     */
    List<TopicPo> getTopics();

    /**
     * 新建专题
     *
     * @param topicPo TopicPo
     */
    void addTopic(TopicPo topicPo);

    /**
     * 更新专题
     *
     * @param topicPo TopicPo
     */
    void updateTopic(TopicPo topicPo);

    /**
     * 删除专题
     *
     * @param id 专题ID
     */
    void deleteTopic(Integer id);

    TopicPo doLast();
}
