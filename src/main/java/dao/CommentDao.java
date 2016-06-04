package dao;

import domain.Comment;

import java.util.List;

/**
 * Created by cqx on 16/5/10.
 */
public interface CommentDao extends BaseHibDao<Comment> {
    public List findComment();
}
