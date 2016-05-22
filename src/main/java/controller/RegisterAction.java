package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import dao.UserDaoHibImpl;
import domain.User.User;
import domain.User.UserInfo;
import service.UserService;
import service.UserServiceImpl;

import java.util.Date;

/**
 * Created by cqx on 2016/5/15.
 */
public class RegisterAction extends ActionSupport {

    private UserService userService = new UserServiceImpl();


    public String register(){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        UserDao userDao = new UserDaoHibImpl();
        User user = new User();
        user.setPassword("123");
        user.setUsername("admin01");
//        userService.generateToken(user);
        UserInfo userInfo = new UserInfo();
        userInfo.setAcademy("软工");
        userInfo.setAge(22);
        userInfo.setEnrolmentDate(new Date(2013, 9, 1));
        userInfo.setInfoVisible(true);
        userInfo.setLabel("懒人无留言");

        user.setUserInfo(userInfo);
//        userService.createUser(user);
        userDao.save(user);
        System.out.println("done!");


        return SUCCESS;
    }

}
