package com.mamba.talk.dao;

import com.mamba.talk.model.bean.UserBean;
import com.mamba.talk.util.DbUtil;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:13:39
 * @description 用户操纵数据库
 */
public class UserDaoImpl {

    private DbUtil dbUtil = new DbUtil();

    /**
     * 插入用户信息
     *
     * @param userBean
     * @return
     */
    public boolean insertUser(UserBean userBean) {
        String sql = "insert into user (user_name,password,salt) values (?,?,?)";

        String[] params = new String[]{userBean.getUsername(), userBean.getPassword(), userBean.getSalt()};

        return dbUtil.insert(sql, params);
    }

    public UserBean findUser(String username) {
        String sql = "select *from user where user_name = ?";

        return dbUtil.queryOne(sql, username);
    }
}
