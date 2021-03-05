package com.mamba.talk.db;

import com.mamba.talk.model.bean.PostBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author JoeBig7
 * @date 2021/3/2 11:33:46
 */
public class PostDbTemplate extends GenericDbTemplate<PostBean> {

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

    @Override
    public boolean doDeleteOne(Connection conn, PreparedStatement preparedStatement, String sql, Integer... params) throws SQLException {
        conn.prepareStatement(sql);
        preparedStatement.setInt(1, params[0]);

        return preparedStatement.execute(sql);
    }


    @Override
    public PostBean doFindById(Connection conn, PreparedStatement preparedStatement, String sql, Integer... params) throws SQLException {
        conn.prepareStatement(sql);
        preparedStatement.setInt(1, params[0]);

        ResultSet rs = preparedStatement.executeQuery(sql);

        while (rs.next()) {
            PostBean postBean = new PostBean();
            postBean.setId(rs.getLong("id"));
            postBean.setTitle(rs.getString("title"));
            postBean.setContent(rs.getString("content"));
            postBean.setTitle(rs.getString("title"));
            postBean.setIsDeleted(rs.getInt("is_deleted"));

            return postBean;
        }
        return null;
    }


}
