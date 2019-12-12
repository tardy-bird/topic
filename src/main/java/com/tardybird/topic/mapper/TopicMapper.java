package com.tardybird.topic.mapper;

import com.tardybird.topic.po.TopicPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nick
 */
@Component
@Mapper
public interface TopicMapper {

    /**
     * topic details
     *
     * @param id topic id
     * @return a topic
     */
    @Select("select id,gmt_create,gmt_modified,is_deleted,pic_url_list,content " +
            "from topic where id=#{id} and is_deleted=0 ")
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
            "from topic where is_deleted=0 ")
    @ResultMap(value = "topic")
    List<TopicPo> getTopics();

    /**
     * add topic
     *
     * @param topic a vo
     */
    @Insert("insert into topic(gmt_create,gmt_modified,is_deleted,pic_url_list,content)" +
            "values(now(),now(),0,#{picUrlList},#{content})")
    void addTopic(TopicPo topic);

    /**
     * xxx
     *
     * @param topic topic object
     */
    @Update("update topic " +
            "set gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},is_deleted=#{beDeleted}," +
            "pic_url_list=#{picUrlList},content=#{content} where id=#{id} and is_deleted=0 ")
    void updateTopic(TopicPo topic);

    /**
     * xxx
     *
     * @param topic topic object
     */
    @Update("update topic set is_deleted=1 where id=#{id}")
    void deleteTopic(TopicPo topic);
}
