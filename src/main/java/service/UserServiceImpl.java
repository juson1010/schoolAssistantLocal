package service;


import dao.UserDao;
import dao.UserDaoHibImpl;
import dao.UserInfoDao;
import domain.User.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by cqx on 16/5/11.
 */
@Service
public class UserServiceImpl implements UserService {

    //  private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Autowired
    private UserDao userDao ;// ctx.getBean("userDao", UserDaoHibImpl.class) ;

    @Autowired
    private UserInfoDao userInfoDao;

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public boolean checkUser(String username, String password) {
        System.out.println("userDao  null is "+(userDao==null)+" ");
        if (userDao == null) {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            userDao = ctx.getBean("userDao",UserDaoHibImpl.class);

        }
        return userDao.checkUser(username, password);
    }

    public boolean createUser(User user) {


        userInfoDao.save(user.getUserInfo());
        userDao.save(user);
        return true;
    }


    public boolean updateUser(User user) {

        if (user.getUserInfo().getId() == null){
            userInfoDao.save(user.getUserInfo());
        }
        userDao.update(user);
        return true;
    }


    public boolean deleteUser(User user) {

        userDao.delete(user);
        return true;
    }


    public User getUser(String userId) {
        return null;
    }


    public User getUserByUsername(String username){

        String hql = "from User where 1=1 and username ='"+username+"'";
        List list = userDao.find(hql);
        User user = null;
        if (list.size()>0) user =(User) list.get(0);

        return user;
    }

    public List getAllUsers(String school, String academy) {
        return null;
    }


    public List getUsers(String hql) {
        return null;
    }


    public PageBean getAllUsersByPage() {
        return null;
    }

    public void generateToken(User user) {
        user.setToken(RandomStringUtils.randomAlphanumeric(64));
        user.setTokenExpDate(DateUtils.addDays(new Date(), 30));
    }
    public boolean verifyPassword(User user, String password) {

        String hashedPassword = DigestUtils.md5Hex(password + user.getSalt());
        if (hashedPassword.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public  void refreshToken(User user) {
        if (user != null && (user.getTokenExpDate() == null || user.getTokenExpDate().compareTo(new Date()) < 0)) {
            generateToken(user);
            userDao.update(user);
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public boolean isExist(String username){
        return userDao.isExist(username);
    }

}

