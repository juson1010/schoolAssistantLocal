package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import dao.UserDaoHibImpl;
import domain.User.User;
import domain.User.UserInfo;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by cqx on 2016/5/15.
 */
@Controller
public class RegisterAction extends ActionSupport {


    @Autowired
    private UserService userService;
    public UserService getUserService() {return userService;}
    public void setUserService(UserService userService) {this.userService = userService;}

    private String username;
    private String password;
    private boolean usernameIsExist;

    public boolean isUsernameIsExist() {return usernameIsExist;}
    public void setUsernameIsExist(boolean usernameIsExist) {this.usernameIsExist = usernameIsExist;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}


    public String register(){

        if (!userService.isExist(username)) {
            System.out.println("enter register action !");
            User user = new User();
            user.setPassword(password);
            user.setUsername(username);
            userService.generateToken(user);
            UserInfo userInfo = new UserInfo();
            user.setUserInfo(userInfo);

            userService.createUser(user);
            System.out.println("done!");

            Map session= ActionContext.getContext().getSession();
            session.put("username", username);
            session.put("user",user);

            return "success";
        }else

            return "failure";
    }



    private String name;
    private String school;
    private String academy;
    private String snoId;
    private String enrolmentDate;
    private boolean userInfoUpdateIfSuccess;
    public String getName() {   return name;    }
    public void setName(String name) {  this.name = name;   }
    public String getSchool() {return school;}
    public void setSchool(String school) {this.school = school;}
    public String getAcademy() {return academy;}
    public void setAcademy(String academy) {this.academy = academy;}
    public String getSnoId() {return snoId;}
    public void setSnoId(String snoId) {this.snoId = snoId;}
    public String getEnrolmentDate() {return enrolmentDate;}
    public void setEnrolmentDate(String enrolmentDate) {this.enrolmentDate = enrolmentDate;}
    public boolean isUserInfoUpdateIfSuccess() {return userInfoUpdateIfSuccess;}
    public void setUserInfoUpdateIfSuccess(boolean userInfoUpdateIfSuccess) {this.userInfoUpdateIfSuccess = userInfoUpdateIfSuccess;}

    public String userInfo() throws  Exception{

        System.out.println("enter RegisterAction userInfo method !");

        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);

        HttpSession session = request.getSession();
        User curUser = (User)session.getAttribute("user");

        UserInfo userInfo ;
        if (curUser.getUserInfo() != null){
            userInfo = curUser.getUserInfo();
        }else{
            userInfo = new UserInfo();
        }

        if (name != null){
            userInfo.setName(name);
        }
        if (school != null){
            userInfo.setSchool(school);
        }
        if (academy != null){
            userInfo.setAcademy(academy);
        }
        if (snoId != null){
            userInfo.setSnoId(snoId);
        }
        if (enrolmentDate != null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
            java.util.Date date=sdf.parse(enrolmentDate);
            userInfo.setEnrolmentDate(date);
        }
        if (curUser.getUserInfo() == null)
            curUser.setUserInfo(userInfo);
        userInfoUpdateIfSuccess = userService.updateUser(curUser);

        return SUCCESS;
    }
    public String checkUserIsExist(){

        System.out.println("enter RegisterAction isExist");
        usernameIsExist = userService.isExist(username);
        System.out.println("username is "+usernameIsExist);

        return SUCCESS;
    }

    private UserInfo info;

    public UserInfo getInfo() {return info;}
    public void setInfo(UserInfo info) {this.info = info;}

    public String userInfoGetInfo(){

        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);

        HttpSession session = request.getSession();
        User curUser = (User)session.getAttribute("user");
        info = curUser.getUserInfo();

        return SUCCESS;
    }

    public boolean isExist(){

        return userService.isExist(username);
    }

}
