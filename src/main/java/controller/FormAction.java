package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Form.Form;
import domain.Questionnaire.Questionnaire;
import domain.Unit;
import domain.UnitType;
import domain.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.FormService;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cqx on 2016/5/25.
 */
@Controller
public class FormAction extends ActionSupport {


    static  String prefix = "http://localhost:8080/formShow.html?formId=";
    /*
    * 创建表格部分 开始
    * create form start
    * */
    @Autowired
    private FormService formService;
    private boolean createFormIsSuccess;
    private String filename;
    private String form_deadline;
    public boolean isCreateFormIsSuccess() {return createFormIsSuccess;}
    public void setCreateFormIsSuccess(boolean createFormIsSuccess) {this.createFormIsSuccess = createFormIsSuccess;}
    public String getFilename() {return filename;}
    public void setFilename(String filename) {this.filename = filename;}
    public String getForm_deadline() {return form_deadline;}
    public void setForm_deadline(String form_deadline) {this.form_deadline = form_deadline;}
    public FormService getFormService() {return formService;}
    public void setFormService(FormService formService) {this.formService = formService;}

    public String create() throws  Exception{


        List<Unit> units=new ArrayList<Unit>();

        String[] unitTitleArray = (String[])ActionContext.getContext().getParameters().get("unitTitle");
        String[] unitTypeArray = (String[])ActionContext.getContext().getParameters().get("unitType");
        String[] unitIsRequiredArray = (String[])ActionContext.getContext().getParameters().get("unitIsRequired");
        String[] indexs = (String[])ActionContext.getContext().getParameters().get("formAddIndex");

        if (unitTitleArray != null)
            System.out.println("unitTitle size is "+unitTitleArray.length);

        if (unitTypeArray != null)
            System.out.println("unitType size is "+unitTypeArray.length);
        if (unitIsRequiredArray != null)
            System.out.println("unitIsRequired size is "+unitIsRequiredArray.length);

        if (indexs != null)
            System.out.println("indexs size is "+indexs.length);

        int size = 0;
        if (unitTitleArray != null)
            size = unitTitleArray.length;

        List<String> titles = new ArrayList<String>();

        for (int i = 0;i<size;i++){
            titles.add(unitTitleArray[i]);
            Unit unit = new Unit();

            unit.setTitle(unitTitleArray[i]);

            if (unitTypeArray[i].equals("TEXT")){
                unit.setType(UnitType.UnitType_TEXT);

            }else if (unitTypeArray[i].equals("CHECKBOX")){
                unit.setType(UnitType.UnitType_CHECKBOX);

                String[] contents = (String[])ActionContext.getContext().getParameters().get("form_unit_content_"+indexs[i]);
                List<String> unitContents = new ArrayList<String>();
                for (int j = 0;j<contents.length;j++){
                    unitContents.add(contents[j]);
                }
                unit.setContents(unitContents);

            }else if(unitTypeArray[i].equals("SELECT")) {
                unit.setType(UnitType.UnitType_SELECT);

                String[] contents = (String[])ActionContext.getContext().getParameters().get("form_unit_content_"+indexs[i]);
                List<String> unitContents = new ArrayList<String>();
                for (int j = 0;j<contents.length;j++){
                    unitContents.add(contents[j]);
                }
                unit.setContents(unitContents);

            }

            if (unitIsRequiredArray[i].equals("true")){
                unit.setRequired(true);
            }else{
                unit.setRequired(false);
            }

            units.add(unit);
        }

        Form form = new Form();

        //设置创建者
        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");
        session.put("titles",titles);

        System.out.println("user id is "+user.getId());
        form.setCreatorUserId(user.getId().toString());


        //设置截止时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date=sdf.parse(form_deadline);
        form.setDeadline(date);

        //设置单元
        form.setUnits(units);

        //设置创建时间
        Date curDate=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        form.setCreateTime(format.format(curDate));

        //设置表格名
        form.setFilename(filename);

        //创建表格
        Integer formId = (Integer)formService.createForm(form);
        session.put("formId",formId);



        return "success";


    }

    /*
    * 创建表格部分 结束
    * create form end
    * */


    /*
    * 以表单形式显示表格 开始
    * show form  start
    * */
    //json  init form data for formResult
    private List<Map> dataForInitForm ;
    public List<Map> getDataForInitForm() {return dataForInitForm;}
    public void setDataForInitForm(List<Map> dataForInitForm) {this.dataForInitForm = dataForInitForm;}

    private Integer formId ;
    public Integer getFormId() {return formId;}
    public void setFormId(Integer formId) {this.formId = formId;}

    public String show(){

        dataForInitForm = new ArrayList<Map>();
        Form form = formService.getForm(formId.toString());

        List<Unit> units =  form.getUnits();
        Map<String,Object> m2 = new HashMap<String, Object>();
        m2.put("filename",form.getFilename());
        dataForInitForm.add(m2);
        for (Unit unit : units) {

            Map<String,Object> m = new HashMap<String, Object>();
            m.put("title",unit.getTitle());
            m.put("type",unit.getType().toString());
            System.out.println("type is "+unit.getType().toString());
            m.put("contents",unit.getContents());
            m.put("isRequired",unit.isRequired());
            dataForInitForm.add(m);
        }



        return "success";
    }


    public String loadInitData(){
        System.out.println("enter FormAction loadInitFormData");

        dataForInitForm = new ArrayList<Map>();
        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");

        Map<String,String> map = new HashMap<String, String>();

        System.out.println("formId is "+session.get("formId"));

        List<String> titles = (List<String>) session.get("titles");
        System.out.println("title size  is "+titles.size());

        map.put("url",prefix+((Integer)session.get("formId")).toString());
        map.put("formId",((Integer)session.get("formId")).toString());
        dataForInitForm.add(map);
        List<Map> t = new ArrayList<Map>();
        for (int i = 0;i<titles.size();i++){
            Map<String,String> tMap = new HashMap<String, String>();
            tMap.put("title",titles.get(i));
            t.add(tMap);
        }

        Map<String,List> m = new HashMap<String, List>();
        m.put("titles",t);
        dataForInitForm.add(m);
        return SUCCESS;
    }

    @Autowired
    private UserService userService;

    public UserService getUserService() {return userService;}
    public void setUserService(UserService userService) {this.userService = userService;}

    public String submit(){

        Form form = formService.getForm(formId.toString());
        System.out.println(form.toString());
        List<Unit> units =  form.getUnits();

        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");
        User userAdd = userService.getUser(user.getId().toString());


        boolean flag = true;
        int index = 0;

        Iterator<User> iter = form.getUsers().iterator();

        int k = 0;
        while(iter.hasNext()){

            User cur = (User)iter.next();
            if (cur.getId().equals(user.getId())){
                flag = false;
                index = k;
                break;
            }

            k++;
        }

        if (flag) {
            form.getUsers().add(userAdd);
        }



        for (int i = 1 ; i<=units.size();i++) {

            Unit unit = units.get(i-1);
            String[] tanswer = (String[])ActionContext.getContext().getParameters().get("unitname_"+i);
            String answer = tanswer[0];
            if (answer == null) answer = "";
            System.out.println("answer is "+answer);
            if (unit.getAnswers() == null)  {
                List<String> answers = new ArrayList<String>();
                unit.setAnswers(answers);
            }

            if (!flag){
                unit.getAnswers().set(index,answer);
            }else {
                unit.getAnswers().add(answer);
            }
        }

        formService.updateForm(form);

        return "success";
    }



    private List<Map> loadDataForForm ;
    public List<Map> getLoadDataForForm() {return loadDataForForm;}
    public void setLoadDataForForm(List<Map> loadDataForForm) {this.loadDataForForm = loadDataForForm;}

    public String loadData(){


        loadDataForForm = new ArrayList<Map>();
        System.out.println("enter FormAction loadData");
        Form form = formService.getForm(formId.toString());

        System.out.println("formId is "+formId.toString());
        List<Unit> units = form.getUnits();

        System.out.println("units size is "+units.size());

        System.out.println("form user size "+form.getUsers().size());

        for(int i = 0;i<form.getUsers().size();i++) {
            int j = 0;
//            System.out.println("user id is "+form.getUsers().get(i).getId());
            Map<String, String> map = new HashMap<String, String>();
            for (Unit unit : units) {

                map.put("title"+j, unit.getAnswers().get(i));

                System.out.println("title"+j+" answer is "+unit.getAnswers().get(i));
                j++;

            }
            loadDataForForm.add(map);

        }


        return "success";
    }



}
