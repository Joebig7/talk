package com.mamba.talk.service;

import com.mamba.talk.dao.PostDaoImpl;
import com.mamba.talk.model.bean.PostBean;
import com.mamba.talk.model.bean.UserBean;
import com.mamba.talk.model.common.RestResp;
import com.mamba.talk.util.CookieUtil;
import com.mamba.talk.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author JoeBig7
 * @date 2021/3/2 11:24:50
 */
public class PostServiceImpl {

    private UserServiceImpl userService = new UserServiceImpl();

    private PostDaoImpl postDao = new PostDaoImpl();

    public RestResp publish(String title, String content, String id, HttpServletRequest req) {
        UserBean userBean = CookieUtil.getUserInfo(req);

        if (StringUtil.isBlank(id)) {
            //add
            PostBean postBean = new PostBean();
            postBean.setContent(content);
            postBean.setTitle(title);
            postBean.setUserId(userBean.getId());

            postDao.insertOne(postBean);
        } else {
            //update
            PostBean postBean = new PostBean();
            postBean.setContent(content);
            postBean.setTitle(title);
            postBean.setUserId(userBean.getId());
            postBean.setId(Long.parseLong(id));

            postDao.updateOne(postBean);
        }

        return new RestResp();

    }
}
