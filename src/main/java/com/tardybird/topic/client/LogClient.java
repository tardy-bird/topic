package com.tardybird.topic.client;

/**
 * @author DIX
 * @version 1.0
 * @description
 * @date 2019/12/17 14:38
 */
import com.tardybird.topic.domain.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "Log")
public interface LogClient {
    /**
     * x
     *
     * @param log x
     */
    @PostMapping("/log")
    void addLog(@RequestBody Log log);
}
