package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Form.Form;
import domain.Questionnaire.Questionnaire;
import domain.Unit;
import domain.UnitType;
import domain.User.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cqx on 2016/5/25.
 */
public class FormAction extends ActionSupport {


    private boolean createFormIsSuccess;

    private String filename;
    private String form_deadline;

    public boolean isCreateFormIsSuccess() {return createFormIsSuccess;}
    public void setCreateFormIsSuccess(boolean createFormIsSuccess) {this.createFormIsSuccess = createFormIsSuccess;}
    public String getFilename() {return filename;}
    public void setFilename(String filename) {this.filename = filename;}
    public String getForm_deadline() {return form_deadline;}
    public void setForm_deadline(String form_deadline) {this.form_deadline = form_deadline;}

    public String create() throws  Exception{


        List<Unit> units=new ArrayList<Unit>();
        Form form = new Form();
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
        //得到了username
        Map session=ActionContext.getContext().getSession();
        User user = (User)session.get("user");

        String[] unitTitleArray = (String[])ActionContext.getContext().getParameters().get("unitTitle");

        String[] unitTypeArray = (String[])ActionContext.getContext().getParameters().get("unitType");

        String[] unitIsRequiredArray = (String[])ActionContext.getContext().getParameters().get("unitIsRequired");
        int size = unitTitleArray.length;
        Unit unit = new Unit();
        for (int i = 0;i<size;i++){

            unit.setTitle(unitTitleArray[i]);

            if (unitTypeArray[i].equals("TEXT")){
                unit.setType(UnitType.UnitType_TEXT);
            }else if (unitTypeArray[i].equals("CHECKBOX")){
                unit.setType(UnitType.UnitType_CHECKBOX);
            }else if(unitTypeArray[i].equals("SELECT")) {
                unit.setType(UnitType.UnitType_SELECT);
            }

            if (unitIsRequiredArray[i].equals("true")){
                unit.setRequired(true);
            }else{
                unit.setRequired(false);
            }

            units.add(unit);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date=sdf.parse(form_deadline);
        form.setDeadline(date);

        form.setUnits(units);
        Date curDate=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        form.setCreateTime(format.format(curDate));





        return "success";


    }

}
