package controller;

import java.util.Map;

import service.UserService;
import service.UserServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

    private String username;
    private String password;
    public String login() throws Exception{
        System.out.println("username "+username+" password : "+password);
        UserService userService=new UserServiceImpl();
        boolean flag=userService.checkUser(username, password);
        if (flag) {
            Map session=ActionContext.getContext().getSession();
            session.put("user", username);
            return "success";
        }else {
            return "failure";
        }

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
