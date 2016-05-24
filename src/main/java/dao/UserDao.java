package dao;


import domain.User.User;

/**
 * Created by cqx on 16/5/10.
 */
public interface UserDao extends BaseHibDao<User> {
    public boolean checkUser(String username,String password);
}
