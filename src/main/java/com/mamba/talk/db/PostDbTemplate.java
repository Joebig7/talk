package com.mamba.talk.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author JoeBig7
 * @date 2021/3/2 11:33:46
 */
public class PostDbTemplate extends GenericDbTemplate {

    @Override
    public void doInsertOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException {
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, params[0]);
        preparedStatement.setString(2, params[1]);
        preparedStatement.setString(3, params[2]);
        preparedStatement.execute();
    }

    @Override
    public int doUpdateOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException {
        conn.prepareStatement(sql);
        preparedStatement.setString(1, params[0]);
        preparedStatement.setString(2, params[1]);
        preparedStatement.setString(3, params[2]);
        return preparedStatement.executeUpdate();
    }
}
