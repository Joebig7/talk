package com.mamba.talk.util;

import com.google.gson.Gson;

/**
 * @Author JoeBig7
 * @date 2021/2/19 15:23:36
 */
public class JsonUtil {

    private static final Gson gson = new Gson();

    public static String toJson(Object data) {
        return gson.toJson(data);
    }
}
