package com.tardybird.topic.mapper;

import com.tardybird.topic.domain.Topic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
            "from topic where id=#{id}")
    @Results(id = "topic", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "gmtCreate", column = "gmt_create", javaType = LocalDateTime.class),
            @Result(property = "gmtModified", column = "gmt_modified", javaType = LocalDateTime.class),
            @Result(property = "beDeleted", column = "is_deleted", javaType = Boolean.class),
            @Result(property = "picUrlList", column = "pic_url_list", javaType = String.class),
            @Result(property = "content", column = "content", javaType = String.class),
    })
    Topic getTopicDetail(Integer id);


    /**
     * add topic
     *
     * @param topic a vo
     */
    @Insert("insert into topic(gmt_create,gmt_modified,is_deleted,pic_url_list,content)" +
            "values(now(),now(),0,#{picUrlList},#{content})")
    void addTopic(Topic topic);

    /**
     * xxx
     *
     * @param topic topic object
     */
    @Update("update topic " +
            "set gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},is_deleted=#{beDeleted}," +
            "pic_url_list=#{picUrlList},content=#{content} where id=#{id}")
    void updateTopic(Topic topic);

    /**
     * xxx
     *
     * @param topic topic object
     */
    @Update("delete from topic where id=#{id}")
    void deleteTopic(Topic topic);
}
