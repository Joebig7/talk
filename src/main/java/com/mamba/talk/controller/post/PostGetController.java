package com.mamba.talk.controller.post;

import com.mamba.talk.controller.constant.ExceptionConstant;
import com.mamba.talk.controller.constant.PostConstant;
import com.mamba.talk.exception.IllegalRequestArgumentException;
import com.mamba.talk.model.common.RestResp;
import com.mamba.talk.service.PostServiceImpl;
import com.mamba.talk.util.JsonUtil;
import com.mamba.talk.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author JoeBig7
 * @date 2021/2/22 14:37:50
 * @description 发布删除
 */
public class PostGetController extends HttpServlet {


    PostServiceImpl postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=UTF-8");

        String id = req.getParameter(PostConstant.ID);
        if (StringUtil.isBlank(id)) {
            throw new IllegalRequestArgumentException(ExceptionConstant.ILLEGAL_PARAMETER_EXCEPTION);
        }

        RestResp restResp = postService.get(id);
        PrintWriter out = resp.getWriter();

        out.println(JsonUtil.toJson(restResp));
        out.flush();
    }

}
