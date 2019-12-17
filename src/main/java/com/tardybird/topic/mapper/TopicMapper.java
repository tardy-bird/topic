package com.tardybird.topic.mapper;

import com.tardybird.topic.po.TopicPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
    @Select("select id,gmt_create,gmt_modified,is_deleted,pic_url_list,content " +
            "from oomall_topic where id=#{id} and is_deleted=0 ")
    @Results(id = "topic", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", javaType = LocalDateTime.class),
            @Result(property = "gmtModified", column = "gmt_modified", javaType = LocalDateTime.class),
            @Result(property = "beDeleted", column = "is_deleted", javaType = Boolean.class),
            @Result(property = "picUrlList", column = "pic_url_list", javaType = String.class),
            @Result(property = "content", column = "content", javaType = String.class),
    })
    TopicPo getTopicDetail(Integer id);

    /**
     * x
     *
     * @return x
     */
    @Select("select id,gmt_create,gmt_modified,is_deleted,pic_url_list,content " +
            "from oomall_topic where is_deleted=0 ")
    @ResultMap(value = "topic")
    List<TopicPo> getTopics();

    /**
     * add topic
     *
     * @param topicPo a vo
     */
    @Insert("insert into oomall_topic(gmt_create,gmt_modified,is_deleted,pic_url_list,content)" +
            "values(now(),now(),0,#{picUrlList},#{content})")
    void addTopic(TopicPo topicPo);

    /**
     * xxx
     *
     * @param topicPo topic object
     */
    @Update("update oomall_topic set gmt_modified=now(),is_deleted=#{beDeleted}," +
            "pic_url_list=#{picUrlList},content=#{content} where id=#{id}")
    int updateTopic(TopicPo topicPo);

    /**
     * xxx
     *
     * @param
     */
    @Update("update oomall_topic set is_deleted=1 where id=#{id}")
    void deleteTopic(Integer id);
}
