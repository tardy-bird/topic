package com.tardybird.topic.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nick
 */
public class ResponseUtil {

    public static Object ok(Object data) {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", 200);
        objectMap.put("errmsg", "成功");
        objectMap.put("data", data);
        return objectMap;
    }


    public static Object fail(int errno, String errmsg) {
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("errno", errno);
        objectMap.put("errmsg", errmsg);
        return objectMap;
    }

    public static Object cantFind() {
        return fail(650, "该话题是无效话题");
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
}
