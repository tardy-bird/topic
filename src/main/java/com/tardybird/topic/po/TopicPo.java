package com.tardybird.topic.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 专题信息
 *
 * @author 数据库与对象模型标准组
 * @date Created in 16:00 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TopicPo {

    private Integer id;
    /**
     * 专题图片的url的list
     * JSON格式: {"pictures":[xxx,xxx]}, xxx为图片的url
     */
    private String picUrlList;
    /**
     * 专题的内容
     */
    private String content;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

}
