package com.tardybird.topic.controller;

import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.service.impl.TopicServiceImpl;
import com.tardybird.topic.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author nick
 */
@RestController
@RequestMapping("/topicsService")
public class TopicController {

    private final
    TopicServiceImpl topicService;

    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }

    /**
     * 用户获取专题列表
     *
     * @param page  分页页数
     * @param limit 分页大小
     * @return 专题列表
     */
    @GetMapping("/topics")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {
        if (page == null || limit == null || page < 0 || limit < 0) {
            return ResponseUtil.badArgument();
        }
        Object object = topicService.getTopics(page, limit);
        return ResponseUtil.ok(object);
    }

    /**
     * 用户获取专题详情
     *
     * @param id 专题ID
     * @return 专题详情
     */
    @GetMapping("/topics/{id}")
    public Object detail(@NotNull @PathVariable Integer id) {
        Topic topic = topicService.getTopicDetail(id);
        return ResponseUtil.ok(topic);
    }


    /**
     * 管理员添加专题
     *
     * @param topic xxx
     * @return xxx
     */
    @PostMapping("/topics")
    public Object create(@RequestBody Topic topic) {
        if (topic == null) {
            return ResponseUtil.fail();
        }
        if (topic.getPicUrlList() == null || topic.getContent() == null) {
            return ResponseUtil.badArgument();
        }
        topicService.addTopic(topic);
        return ResponseUtil.ok();
    }


    /**
     * 管理员编辑专题
     *
     * @param topic xxx
     * @param id    xxx
     * @return xxx
     */
    @PutMapping("/topics/{id}")
    public Object update(@RequestBody Topic topic, @PathVariable Integer id) {
        if (topic == null) {
            return ResponseUtil.fail();
        }
        topic.setId(id);
        topicService.updateTopic(topic);
        return ResponseUtil.ok();
    }

    /**
     * 管理员删除专题
     *
     * @param id xxx
     * @return xxx
     */
    @DeleteMapping("/topics/{id}")
    public Object delete(@PathVariable Integer id) {
        Topic topic = new Topic();
        topic.setId(id);
        topicService.deleteTopic(topic);
        return ResponseUtil.ok(topic);
    }

}
