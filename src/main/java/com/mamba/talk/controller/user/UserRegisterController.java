package com.mamba.talk.controller.user;

import com.mamba.talk.controller.constant.ExceptionConstant;
import com.mamba.talk.controller.constant.UserConstant;
import com.mamba.talk.exception.IllegalRequestArgumentException;
import com.mamba.talk.service.UserServiceImpl;
import com.mamba.talk.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author JoeBig7
 * @date 2021/2/8 18:21:43
 * @Description 用户注册Controller
 */
public class UserRegisterController extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter(UserConstant.USER_NAME);
        String password = req.getParameter(UserConstant.PASSWORD);

        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            throw new IllegalRequestArgumentException(ExceptionConstant.ILLEGAL_PARAMETER_EXCEPTION);
        }


        userService.register(username,password);

    }
}
