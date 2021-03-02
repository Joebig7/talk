package com.mamba.talk.dao;

import com.mamba.talk.db.PostDbTemplate;
import com.mamba.talk.model.bean.PostBean;

/**
 * @Author JoeBig7
 * @date 2021/3/2 11:33:11
 */
public class PostDaoImpl {

    private PostDbTemplate postDbTemplate = new PostDbTemplate();

    public boolean insertOne(PostBean postBean) {

        String sql = "insert into post (user_id,title,content) values (?,?,?)";

        String[] params = new String[]{postBean.getId() + "", postBean.getTitle(), postBean.getContent()};

        return postDbTemplate.insertOne(sql, params);
    }

    public int updateOne(PostBean postBean) {
        String sql = "update post  set title=? and content=?  where id=?";

        String[] params = new String[]{postBean.getTitle()  , postBean.getContent(), postBean.getId()+""};

        return postDbTemplate.updateOne(sql,params);
    }
}
