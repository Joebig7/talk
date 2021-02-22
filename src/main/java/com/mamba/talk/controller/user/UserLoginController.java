package com.mamba.talk.controller.user;

import com.mamba.talk.controller.constant.ExceptionConstant;
import com.mamba.talk.controller.constant.UserConstant;
import com.mamba.talk.exception.IllegalRequestArgumentException;
import com.mamba.talk.model.common.RestResp;
import com.mamba.talk.service.UserServiceImpl;
import com.mamba.talk.util.JsonUtil;
import com.mamba.talk.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * @Author JoeBig7
 * @date 2021/2/8 18:21:43
 * @Description 用户登录Controller
 */
public class UserLoginController extends HttpServlet {

    private Logger logger = Logger.getLogger("UserLoginController");

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=UTF-8");

        String username = req.getParameter(UserConstant.USER_NAME);
        String password = req.getParameter(UserConstant.PASSWORD);

        logger.info("username====" + username);
        logger.info("password====" + password);

        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            throw new IllegalRequestArgumentException(ExceptionConstant.ILLEGAL_PARAMETER_EXCEPTION);
        }

        RestResp restResp = userService.login(username, password, resp);

        PrintWriter out = resp.getWriter();

        out.println(JsonUtil.toJson(restResp));
        out.flush();
    }
}
