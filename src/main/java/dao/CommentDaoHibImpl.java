package dao;

import domain.Comment;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by cqx on 16/5/10.
 */
public class CommentDaoHibImpl extends BaseDaoHibImpl<Comment> implements CommentDao {


    public List findComment() {
        System.out.println("aaaa");

        Session session=getSession();
        String hql="from Comment as c";
        System.out.println("commentDao  before query ");
        List comment_list=session.createQuery(hql).list();
        System.out.println("commentDao query done!");
        //session.close();
        return comment_list;


    }


}
