package com.mamba.talk.service;

import com.mamba.talk.dao.UserDaoImpl;
import com.mamba.talk.exception.ServiceException;
import com.mamba.talk.model.bean.UserBean;
import com.mamba.talk.util.Md5Util;
import com.mamba.talk.util.StringUtil;

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
}
