package com.mamba.talk.util;

import com.mamba.talk.model.bean.UserBean;

import java.sql.*;
import java.util.Objects;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:13:22
 */
public class DbUtil {

    private static final String url = "jdbc:mysql://47.93.23.143:3306/talk?useUnicode=true&characterEncoding=utf8";
    public static final String username = "root";
    public static final String password = "root";

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return conn;
    }

    public boolean insert(String sql, String... params) {
        boolean result = false;
        conn = getConnection();
        try {
            preparedStatement = conn.prepareStatement(sql, params);
            preparedStatement.setString(1, params[0]);
            preparedStatement.setString(2, params[1]);
            preparedStatement.setString(3, params[2]);
            preparedStatement.execute();
            result = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
            return result;
        }
    }

    public UserBean queryOne(String sql, String... params) {
        conn = getConnection();
        try {
            preparedStatement = conn.prepareStatement(sql, params);
            preparedStatement.setString(1, params[0]);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserBean userBean = new UserBean();
                userBean.setId(resultSet.getLong("id"));
                userBean.setUsername(resultSet.getString("user_name"));
                userBean.setSalt(resultSet.getString("salt"));
                userBean.setPassword(resultSet.getString("password"));

                return userBean;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    private void close() {
        try {
            if (Objects.nonNull(preparedStatement)) {
                preparedStatement.close();
            }

            if (Objects.nonNull(conn)) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
