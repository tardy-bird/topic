package com.tardybird.topic.domain;

import com.tardybird.topic.po.TopicPo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 专题对象
 *
 * @author 数据库与对象模型标准组
 * @date 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Topic extends TopicPo {
    private List<String> pictures;

}
