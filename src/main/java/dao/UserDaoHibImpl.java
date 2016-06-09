package dao;


import domain.User.User;
import org.springframework.stereotype.Repository;

/**
 * Created by cqx on 16/5/10.
 */
@Repository
public class UserDaoHibImpl extends BaseDaoHibImpl<User> implements UserDao {
    public boolean checkUser(String username, String password) {

        return true;
    }

    public boolean isExist(String username){

        String hql = "from User where username = '"+username+"'";

        return (find(hql).size() == 1);
    }

}
