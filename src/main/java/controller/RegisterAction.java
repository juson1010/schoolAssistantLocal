package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import dao.UserDaoHibImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Date;

/**
 * Created by cqx on 2016/5/15.
 */
public class RegisterAction extends ActionSupport {

    private UserService userService = new UserServiceImpl();

    public String register(){


        return SUCCESS;
    }


}
