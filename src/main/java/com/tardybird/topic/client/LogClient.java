package com.tardybird.topic.client;

import com.tardybird.topic.domain.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author nick
 */
@Component
@FeignClient(name = "logService")
public interface LogClient {
    /**
     * 调用日志模块，将管理员操作写到日志
     *
     * @param log 日志对象
     */
    @PostMapping("/log")
    void addLog(@RequestBody Log log);
}
