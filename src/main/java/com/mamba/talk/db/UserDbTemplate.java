package com.mamba.talk.db;

import com.mamba.talk.model.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author JoeBig7
 * @date 2021/3/2 10:48:27
 */
public class UserDbTemplate extends GenericDbTemplate<UserBean> {

    @Override
    public void doInsertOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException {
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, params[0]);
        preparedStatement.setString(2, params[1]);
        preparedStatement.setString(3, params[2]);
        preparedStatement.execute();
    }

    @Override
    public UserBean doQueryOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException {
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, params[0]);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            UserBean userBean = new UserBean();
            userBean.setId(resultSet.getLong("id"));
            userBean.setUsername(resultSet.getString("user_name"));
            userBean.setSalt(resultSet.getString("salt"));
            userBean.setPassword(resultSet.getString("password"));
            userBean.setPortrait(resultSet.getString("portrait"));
            return userBean;
        }

        return null;
    }
}
