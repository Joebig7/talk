package com.mamba.talk.db;

import com.mamba.talk.model.bean.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:13:22
 */
public abstract class AbstractDbTemplate<T> {

    private static final String url = "jdbc:mysql://47.93.23.143:3306/talk?useUnicode=true&characterEncoding=utf8";
    public static final String username = "root";
    public static final String password = "root";

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;

    /**
     * 获取连接
     *
     * @return
     */
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

    /**
     * 关闭资源连接
     */
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

    /**
     * @param sql
     * @param params
     * @return
     */
    public boolean insertOne(String sql, String... params) {
        boolean result = false;
        conn = getConnection();
        try {
            doInsertOne(conn, preparedStatement, sql, params);
            result = true;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            close();
            return result;
        }
    }

    public abstract void doInsertOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException;

    public T queryOne(String sql, String... params) {
        conn = getConnection();
        try {
            doQueryOne(conn, preparedStatement, sql, params);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public abstract T doQueryOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException;

    public int updateOne(String sql, String... params) {
        conn = getConnection();
        try {
            return doUpdateOne(conn, preparedStatement, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public abstract int doUpdateOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException;

}
