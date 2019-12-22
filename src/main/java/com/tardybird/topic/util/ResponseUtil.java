package com.tardybird.topic.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nick
 */
public class ResponseUtil {

    public static Object ok(Object data) {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", 0);
        objectMap.put("errmsg", "成功");
        objectMap.put("data", data);
        return objectMap;
    }

    public static Object ok() {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", 0);
        objectMap.put("errmsg", "成功");
        return objectMap;
    }


    public static Object fail(int errno, String errmsg) {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", errno);
        objectMap.put("errmsg", errmsg);
        return objectMap;
    }

    public static Object badArgument() {
        return fail(580, "参数不合法");
    }


    public static Object failUpdate() {
        return fail(651, "话题更新失败");
    }

    public static Object failAdd() {
        return fail(651, "话题添加失败");
    }

    public static Object failDelete() {
        return fail(652, "话题删除失败");
    }

    public static Object topicNotFound() {
        return fail(654, "话题查看失败");
    }
}
