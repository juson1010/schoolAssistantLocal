package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Form.Form;
import domain.Questionnaire.Questionnaire;
import domain.Resource.ResourceBase;
import domain.Resource.ResourceType;
import domain.User.User;
import domain.User.UserInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ResourceServlet;
import service.ResourceService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cqx on 16/6/11.
 */

@Controller
public class UserProfileAction extends ActionSupport {

    static String prefix = "http://localhost:8080/";
    private String resourceType;
    private String filename;
    @Autowired
    private ResourceService resourceService;

    public String getResourceType() {return resourceType;}
    public void setResourceType(String resourceType) {this.resourceType = resourceType;}
    public String getFilename() {return filename;}
    public void setFilename(String filename) {this.filename = filename;}
    public ResourceService getResourceService() {return resourceService;}
    public void setResourceService(ResourceService resourceService) {this.resourceService = resourceService;}

    private List<Map> dataFormLoadResource = new ArrayList<Map>();
    public List<Map> getDataFormLoadResource() {return dataFormLoadResource;}
    public void setDataFormLoadResource(List<Map> dataFormLoadResource) {this.dataFormLoadResource = dataFormLoadResource;}

    public String loadFormOrQuestionnaireData() throws Exception{


        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");

        List<ResourceBase> resources = select(resourceType,user.getId().toString());

        for(int i = 0;i<resources.size();i++){

            String url = prefix;
            Integer participators = 0;
            if (resourceType.equals("Form")){
                Form form = (Form)resources.get(i);
                participators = form.getUsers().size();
                url += "formResult.html?formId="+form.getId();
            }else{
                Questionnaire questionnaire = (Questionnaire)resources.get(i);
                participators = questionnaire.getUsers().size();
                url += "questionnaireResult.html?questionnaireId="+questionnaire.getId();
            }
            Map<String,String> map = new HashMap<String, String>();

            map.put("filename", resources.get(i).getFilename());
            map.put("createDate",resources.get(i).getCreateTime());
            map.put("participators",participators.toString());
            map.put("resourceId",resources.get(i).getId().toString());
            map.put("url",url);
            dataFormLoadResource.add(map);
        }


        return "success";

    }
    public List select(String tableName ,String creatorUserId) throws Exception{
        System.out.println("enter ResourceAction select !");
        String hql = "from "+tableName+" as e where 1=1 ";

        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        request.setCharacterEncoding("UTF-8");

        filename = new String(request.getParameter("filename").getBytes("iso-8859-1"),"utf-8");
        creatorUserId = request.getParameter("creatorUserId");


        if (filename != null&&!filename.equals("")){//
            hql+=" and e.filename like'"+filename+"%' ";
        }

        if(creatorUserId!=null&&!creatorUserId.equals("")){
            hql+=" and e.creatorUserId = '"+creatorUserId+"' ";
        }




        System.out.println("hql:"+hql);
        List<ResourceBase> resources = resourceService.getResourceByCondition(hql, ResourceType.ResourceType_EBOOK);

        return resources;
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

    private UserInfo info;
    private UserService userService;
    public UserInfo getInfo() {return info;}
    public void setInfo(UserInfo info) {this.info = info;}

    public UserService getUserService() {return userService;}
    public void setUserService(UserService userService) {this.userService = userService;}
    public String userInfoGetInfo(){

        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);

        HttpSession session = request.getSession();
        User curUser = (User)session.getAttribute("user");
        info = curUser.getUserInfo();

        return SUCCESS;
    }

}
