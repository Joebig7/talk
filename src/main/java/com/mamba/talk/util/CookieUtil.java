package com.mamba.talk.util;

import com.mamba.talk.controller.constant.UserConstant;
import com.mamba.talk.model.bean.UserBean;
import com.mamba.talk.service.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author JoeBig7
 * @date 2021/3/2 11:39:10
 */
public class CookieUtil {
    private static UserServiceImpl userService = new UserServiceImpl();

    public static UserBean getUserInfo(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(UserConstant.TOKEN)) {
                String token = cookie.getValue();
                String[] userInfo = token.split("-");
                String userName = userInfo[1];
                return userService.findUserByUserName(userName);
            }
        }

        return null;
    }
}
