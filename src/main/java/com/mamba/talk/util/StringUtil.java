package com.mamba.talk.util;

import java.util.Objects;
import java.util.UUID;

/**
 * @Author JoeBig7
 * @date 2021/2/18 17:58:03
 */
public class StringUtil {

    public static boolean isBlank(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return true;
        }

        return false;
    }

    public static String getRandomUuId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
