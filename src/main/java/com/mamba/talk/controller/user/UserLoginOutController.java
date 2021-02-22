package com.mamba.talk.controller.user;

import com.mamba.talk.controller.constant.ExceptionConstant;
import com.mamba.talk.controller.constant.UserConstant;
import com.mamba.talk.exception.IllegalRequestArgumentException;
import com.mamba.talk.model.common.RestResp;
import com.mamba.talk.service.UserServiceImpl;
import com.mamba.talk.util.JsonUtil;
import com.mamba.talk.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * @Author JoeBig7
 * @date 2021/2/8 18:34:27
 * @Description 用户退出Controller
 */
public class UserLoginOutController extends HttpServlet {

    private Logger logger = Logger.getLogger("UserLoginOutController");

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=UTF-8");

        String username = req.getParameter(UserConstant.USER_NAME);
        logger.info("username====" + username);

        if (StringUtil.isBlank(username)) {
            throw new IllegalRequestArgumentException(ExceptionConstant.ILLEGAL_PARAMETER_EXCEPTION);
        }

        RestResp restResp = userService.loginOut(username, resp, req);

        PrintWriter out = resp.getWriter();

        out.println(JsonUtil.toJson(restResp));
        out.flush();
    }
}
