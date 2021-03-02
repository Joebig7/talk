package com.mamba.talk.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author JoeBig7
 * @date 2021/3/2 10:58:21
 */
public class GenericDbTemplate<T> extends AbstractDbTemplate<T> {

    @Override
    public void doInsertOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException {

    }

    @Override
    public T doQueryOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException{
        return null;
    }

    @Override
    public int doUpdateOne(Connection conn, PreparedStatement preparedStatement, String sql, String... params) throws SQLException {
        return 0;
    }
}
