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
@RequestMapping("/topics")
public class TopicController {

    private final
    TopicServiceImpl topicService;

    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }

    /**
     * 专题列表
     *
     * @param page  分页页数
     * @param limit 分页大小
     * @return 专题列表
     */
    @GetMapping("/")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order) {
        // TODO
        return null;
    }

    /**
     * 专题详情
     *
     * @param id 专题ID
     * @return 专题详情
     */
    @GetMapping("/{id}")
    public Object detail(@NotNull @PathVariable Integer id) {
        return topicService.getTopicDetail(id);
    }

    /**
     * 用户获取专题的相关专题
     *
     * @param id 专题ID
     * @return 相关专题
     */
    @GetMapping("/{id}/related")
    public Object related(@NotNull @PathVariable Integer id) {
        //TODO
        return null;
    }


    /**
     * 管理员查询专题
     *
     * @param title    xxx
     * @param subtitle xxx
     * @param page     xxx
     * @param limit    xxx
     * @param sort     xxx
     * @param order    xxx
     * @return xxx
     */
    @GetMapping
    public Object list(String title, String subtitle,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @RequestParam(defaultValue = "add_time") String sort,
                       @RequestParam(defaultValue = "desc") String order) {
        // TODO
        return null;
    }

    /**
     * 管理员添加专题
     *
     * @param topic xxx
     * @return xxx
     */
    @PostMapping
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
    @PutMapping("/{id}")
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
     * @param topic xxx
     * @param id    xxx
     * @return xxx
     */
    @DeleteMapping("/{id}")
    public Object delete(@RequestBody Topic topic, @PathVariable Integer id) {
        if (topic == null) {
            return ResponseUtil.fail();
        }
        topic.setId(id);
        topicService.deleteTopic(topic);
        return ResponseUtil.ok(topic);
    }

}
