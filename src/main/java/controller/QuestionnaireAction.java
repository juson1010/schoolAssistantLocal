package controller;







import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.WriteAbortedException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.QuestionnaireService;
import service.UnitService;
import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Unit;
import domain.UnitType;
import domain.Questionnaire.Questionnaire;
import domain.User.User;
/**
 * Created by cqx on 2016/5/25.
 */
@Controller
public class QuestionnaireAction extends ActionSupport {
    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    UserService userService;

    @Autowired
    UnitService unitService;

    String filename;
    String typeofQuestionnaireType;
    Date Questionnaire_deadline;


    public QuestionnaireService getQuestionnaireService() {
        return questionnaireService;
    }

    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    public UnitService getUnitService() {
        return unitService;
    }

    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    public String getFilename() {
        return filename;
    }

    public String getTypeofQuestionnaireType() {
        return typeofQuestionnaireType;
    }

    public Date getQuestionnaire_deadline() {
        return Questionnaire_deadline;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setTypeofQuestionnaireType(String typeofQuestionnaireType) {
        this.typeofQuestionnaireType = typeofQuestionnaireType;
    }

    public void setQuestionnaire_deadline(Date questionnaire_deadline) {
        Questionnaire_deadline = questionnaire_deadline;
    }
    //显示问卷
    public String show() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        request.setAttribute("questionList", questionnaireService.getQuestionnaire("1"));

        List<Unit> units=new ArrayList<Unit>();
        Unit unit=new Unit();
        List<String> contents=new ArrayList<String>();

        unit.setRequired(true);
        unit.setTitle("多彩的世界");
        contents.add("蝴蝶");
        contents.add("蜻蜓");
        contents.add("彩虹");
        contents.add("栀子花");
        unit.setContents(contents);
        unit.setType(UnitType.UnitType_CHECKBOX);

        units.add(unit);
        unit=new Unit();
        contents=new ArrayList<String>();
        unit.setRequired(true);
        unit.setTitle("你觉得你幸福吗？");
        contents.add("不幸福");
        contents.add("一般");
        contents.add("挺幸福");
        contents.add("横幸福");
        unit.setContents(contents);
        unit.setType(UnitType.UnitType_RADIO);

        units.add(unit);
        unit=new Unit();
        contents=new ArrayList<String>();
        unit.setRequired(false);
        unit.setTitle("你觉得你幸福吗2？");
        contents.add("不幸福");
        contents.add("一般");
        contents.add("挺幸福");
        contents.add("横幸福");
        unit.setContents(contents);
        unit.setType(UnitType.UnitType_RADIO);

        units.add(unit);

        unit=new Unit();
        contents=new ArrayList<String>();
        unit.setRequired(true);
        unit.setTitle("小朋友，你读几年级了？");
        contents.add("一年级");
        contents.add("二年级");
        contents.add("三年级");
        contents.add("四年级");
        contents.add("五年级");
        contents.add("六年级");
        unit.setContents(contents);
        unit.setType(UnitType.UnitType_SELECT);

        units.add(unit);
        unit=new Unit();
        contents=new ArrayList<String>();
        unit.setRequired(true);
        unit.setTitle("小朋友，你将来想当什么呢？科学家，老师，农民还是什么呢？");
        unit.setContents(contents);
        unit.setType(UnitType.UnitType_TEXT);
        if(unit.getType()==UnitType.UnitType_TEXT)
            System.out.println("hello");
        units.add(unit);

        request.setAttribute("units", units);

        return ERROR;

    }
    //添加新问卷
    public String add() throws Exception {

        List<Unit> units=new ArrayList<Unit>();
        Questionnaire questionnaire=new Questionnaire();
        filename=((String [])ActionContext.getContext().getParameters().get("filename"))[0];
        typeofQuestionnaireType=((String [])ActionContext.getContext().getParameters().get("typeofQuestionnaireType"))[0];
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Questionnaire_deadline= sdf.parse(((String[])ActionContext.getContext().getParameters().get("Questionnaire_deadline"))[0]);

        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
        //得到了username
        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");

        //得到单选题
        int size=((String[])ActionContext.getContext().getParameters().get("a1")).length;
        for (int i = 0; i < size; i++) {
            //五个值分别set，然后add到questionnaire a1 a10 a11 a12 a13
            String selectionName=((String[])ActionContext.getContext().getParameters().get("a1"))[i];
            String op1=((String[])ActionContext.getContext().getParameters().get("a11"))[i];
            String op2=((String[])ActionContext.getContext().getParameters().get("a12"))[i];
            String op3=((String[])ActionContext.getContext().getParameters().get("a13"))[i];
            String op4=((String[])ActionContext.getContext().getParameters().get("a14"))[i];

            Unit unit=new Unit();
            unit.setTitle(selectionName);
            unit.setType(UnitType.UnitType_RADIO);
            List<String> contents=new ArrayList<String>();
            contents.add(op1);
            contents.add(op2);
            contents.add(op3);
            contents.add(op4);
            unit.setContents(contents);

            unitService.createUnit(unit);
            units.add(unit);
            questionnaire.setUnits(units);
            units.clear();
        }
        //得到多选题

        //得到填空题

        questionnaire.setCreatorUserId(user.getId().toString());
        questionnaire.setCreateTime(matter1.format(dt));
        questionnaire.setFilename(filename);
        questionnaire.setType(typeofQuestionnaireType);
        questionnaire.setDeadline(Questionnaire_deadline);
        questionnaireService.createQuestionnaire(questionnaire);
        return SUCCESS;
    }
    //上传填写问卷结果
    @SuppressWarnings("unchecked")
    public String upload() throws Exception{
        Map session=ActionContext.getContext().getSession();
        HttpServletRequest request= ServletActionContext.getRequest();
        //得到填写用户信息，并添加到数据库
        String username =(String)session.get("username");
        Set<User> users=new HashSet<User>();
        User user=userService.getUserByUsername(username);
        users.add(user);
        Questionnaire que=questionnaireService.getQuestionnaire(request.getParameter("resource_id"));
        que.setUsers(users);
        questionnaireService.updateQuestionnaire(que);
        System.out.println(user.getUsername()+" T^T "+que.getFilename());
        //得到表单数据
        Enumeration<String> cb=request.getParameterNames();
        File dest = new File("questionnaireResult.txt");
        BufferedWriter writer  = new BufferedWriter(new FileWriter(dest,true));
        while (cb.hasMoreElements()) {
            // System.out.println(cb.nextElement());可以得到表單中的名字
            String par=cb.nextElement();
            if(par.substring(0, 5).equals("check")){
                String []checks=request.getParameterValues(par);
                for(int i=0;i<checks.length;i++){
                    System.out.println(par+":"+checks[i]);
                }
            }
            else
            {
                System.out.println(par+":"+request.getParameter(par)+"\n");
                writer.write(par+":"+request.getParameter(par)+"\n");
            }
        }
        writer.close();

        return ERROR;
    }

}
