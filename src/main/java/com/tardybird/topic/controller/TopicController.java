package com.tardybird.topic.controller;

import com.tardybird.topic.client.LogClient;
import com.tardybird.topic.domain.Log;
import com.tardybird.topic.domain.Topic;
import com.tardybird.topic.po.TopicPo;
import com.tardybird.topic.service.impl.TopicServiceImpl;
import com.tardybird.topic.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author nick
 */
@RestController
public class TopicController {

    final TopicServiceImpl topicService;
    final LogClient logClient;

    public TopicController(TopicServiceImpl topicService, LogClient logClient) {
        this.topicService = topicService;
        this.logClient = logClient;
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
        Log log;
        if (page == null || limit == null || page < 0 || limit < 0) {

            log = new Log.LogBuilder().type(0).actions("查看专题").status(0).build();
            logClient.addLog(log);

            return ResponseUtil.cantFind();
        }

        log = new Log.LogBuilder().type(0).actions("查看专题").status(1).build();
        logClient.addLog(log);

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
        Log log;
        if (id <= 0) {

            log = new Log.LogBuilder().type(0).actions("查看一个专题").status(0).actionId(id).build();
            logClient.addLog(log);

            return ResponseUtil.cantFind();
        }

        Topic topic = topicService.getTopicDetail(id);

        if (topic == null) {

            log = new Log.LogBuilder().type(0).actions("查看一个专题").status(0).actionId(id).build();
            logClient.addLog(log);

            return ResponseUtil.cantFind();
        }

        log = new Log.LogBuilder().type(0).actions("查看一个专题").status(1).actionId(id).build();
        logClient.addLog(log);

        return ResponseUtil.ok(topic);
    }


    /**
     * 管理员添加专题
     *
     * @param topicPo xxx
     * @return xxx
     */
    @PostMapping("/topics")
    public Object create(@RequestBody TopicPo topicPo) {
        Log log;

        if (topicPo.getContent() == null) {

            log = new Log.LogBuilder().type(1).actions("管理员添加专题").status(0).build();
            logClient.addLog(log);

            return ResponseUtil.failAdd();
        }

        TopicPo topic = topicService.addTopic(topicPo);

        log = new Log.LogBuilder().type(1).actions("管理员添加专题").status(1).build();
        logClient.addLog(log);

        return ResponseUtil.ok(topic);
    }


    /**
     * 管理员编辑专题
     *
     * @param topicPo xxx
     * @param id      xxx
     * @return xxx
     */
    @PutMapping("/topics/{id}")
    public Object update(@RequestBody TopicPo topicPo, @PathVariable Integer id) {
        Log log;
        if (topicPo == null) {

            log = new Log.LogBuilder().type(1).actions("管理员编辑专题").status(0).build();
            logClient.addLog(log);

            return ResponseUtil.failUpdate();
        }

        log = new Log.LogBuilder().type(1).actions("管理员编辑专题").status(1).build();
        logClient.addLog(log);

        topicPo.setId(id);

        TopicPo topic = topicService.updateTopic(topicPo);

        return ResponseUtil.ok(topic);
    }

    /**
     * 管理员删除专题
     *
     * @param id xxx
     * @return xxx
     */
    @DeleteMapping("/topics/{id}")
    public Object delete(@PathVariable Integer id) {
        Log log;
        if (id <= 0) {

            log = new Log.LogBuilder().type(1).actions("管理员删除专题").status(0).build();
            logClient.addLog(log);

            return ResponseUtil.failDelete();
        }

        log = new Log.LogBuilder().type(1).actions("管理员删除专题").status(1).build();
        logClient.addLog(log);

        topicService.deleteTopic(id);

        return ResponseUtil.ok(id);
    }
}
