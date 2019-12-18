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
     * topic details
     *
     * @param id topic id
     * @return a topic
     */
    TopicPo getTopicDetail(Integer id);

    /**
     * x
     *
     * @return x
     */
    List<TopicPo> getTopics();

    /**
     * add topic
     *
     * @param topicPo x
     */
    void addTopic(TopicPo topicPo);

    /**
     * 更新主题
     *
     * @param topicPo x
     */
    void updateTopic(TopicPo topicPo);

    /**
     * 删除主题
     *
     * @param id x
     */
    void deleteTopic(Integer id);
}
