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

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cqx on 2016/5/25.
 */
@Controller
public class FormAction extends ActionSupport {


    @Autowired
    private FormService formService;

    private boolean createFormIsSuccess;

    private String filename;
    private String form_deadline;
    private Map<String,String> formIds = new Hashtable<String, String>();
    private List<String> titles = new ArrayList<String>();
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

        int size = unitTitleArray.length;


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
        formIds.put(user.getId().toString(),formId.toString());

        return "success";


    }

    public String show(){

        return "success";
    }

    //json  init form data for formResult
    private List<Map> dataForInitForm = new ArrayList<Map>();

    public List<Map> getDataForInitForm() {return dataForInitForm;}
    public void setDataForInitForm(List<Map> dataForInitForm) {this.dataForInitForm = dataForInitForm;}

    public String loadInitFormData(){
        System.out.println("enter FormAction loadInitFormData");

        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");

        Map<String,String> map = new HashMap<String, String>();
        map.put("url",formIds.get(user.getId().toString()));
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
}
