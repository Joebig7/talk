package com.mamba.talk.service;

import com.mamba.talk.controller.constant.ExceptionConstant;
import com.mamba.talk.dao.UserDaoImpl;
import com.mamba.talk.exception.ServiceException;
import com.mamba.talk.model.bean.UserBean;
import com.mamba.talk.model.common.RestResp;
import com.mamba.talk.util.Md5Util;
import com.mamba.talk.util.StringUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:02:40
 * @description 用户业务层
 */
public class UserServiceImpl {

    private UserDaoImpl userDao = new UserDaoImpl();

    /**
     * 用户注册
     *
     * @param username
     * @param password
     */
    public void register(String username, String password) {
        boolean isExist = checkUsername(username);

        if (isExist) {
            throw new ServiceException("用户名已存在");
        }

        String salt = StringUtil.getRandomUuId();

        String targetPwd = Md5Util.MD5(new StringBuilder(password).append(salt).toString());

        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(targetPwd);
        userBean.setSalt(salt);


        userDao.insertUser(userBean);
    }

    /**
     * 查询用户名是否已经存在
     *
     * @param username
     * @return
     */
    private boolean checkUsername(String username) {
        return findUserByUserName(username) == null ? false : true;
    }


    public UserBean findUserByUserName(String username) {
        return userDao.findUser(username);
    }

    /**
     * @param username
     * @param password
     */
    public RestResp login(String username, String password, HttpServletRequest request) {

        UserBean userBean = findUserByUserName(username);

        if (Objects.isNull(userBean)) {
            return new RestResp("username or password is not valid", 200, null);
        }

        String realPwd = userBean.getPassword();
        String salt = userBean.getSalt();

        String sourcePwd = Md5Util.MD5(new StringBuilder(password).append(salt).toString());

        if (!realPwd.equals(sourcePwd)) {
            return new RestResp(ExceptionConstant.USE_PWD_ERROR, 200, null);
        }


//        Cookie userCookie = new Cookie("userId",userBean.get)

        return null;

    }
}
