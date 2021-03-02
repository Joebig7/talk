package com.mamba.talk.dao;

import com.mamba.talk.db.UserDbTemplate;
import com.mamba.talk.model.bean.UserBean;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:13:39
 * @description 用户操纵数据库
 */
public class UserDaoImpl {

    private UserDbTemplate userDbTemplate = new UserDbTemplate();

    /**
     * 插入用户信息
     *
     * @param userBean
     * @return
     */
    public boolean insertUser(UserBean userBean) {
        String sql = "insert into user (user_name,password,salt) values (?,?,?)";

        String[] params = new String[]{userBean.getUsername(), userBean.getPassword(), userBean.getSalt()};

        return userDbTemplate.insertOne(sql, params);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    public UserBean findUser(String username) {
        String sql = "select *from user where user_name = ?";

        return userDbTemplate.queryOne(sql, username);
    }
}
