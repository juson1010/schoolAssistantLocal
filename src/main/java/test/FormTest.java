package test;

import domain.Form.Form;
import domain.Unit;
import org.apache.struts2.components.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.FormService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqx on 16/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/java/applicationContext.xml")
public class FormTest {

    @Autowired
    private FormService formService;

    public FormService getFormService() {
        return formService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }


    @Test
    public void select(){


        Form form = formService.getForm("1277952");

        List<Unit> units = form.getUnits();
        for (Unit unit:units) {

            System.out.println("unitTitle is "+unit.getTitle());
            System.out.println("unit Type"+unit.getType());
            if(unit.getContents() != null && unit.getContents().size()>0){
                for (String str:unit.getContents()) {
                    System.out.println("unit content -> "+str);
                }
            }
        }

    }

    @Test
    public void create(){



        Form form = new Form();

//        Unit  unit1  = new Unit();


        java.util.Date curDate=new java.util.Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        form.setCreateTime(format.format(curDate));

        form.setFilename("测试2");
        form.setDeadline(curDate);
        form.setCreatorUserId("1");

        Unit unit = new Unit();

        unit.setRequired(true);
        unit.setTitle("title");
        unit.setRegEx("sda");
        unit.setIndex(1);
        List<String> contents = new ArrayList<String>();
        contents.add("aaaa");
        contents.add("bbb");
        unit.setContents(contents);

        List<Unit> units = new ArrayList<Unit>();

        units.add(unit);

        Unit unit2 = new Unit();

        unit2.setRequired(true);
        unit2.setTitle("title");
        unit2.setRegEx("sda");
        unit2.setIndex(2);
        List<String> contents2 = new ArrayList<String>();
        contents2.add("aaaa2");
        contents2.add("bbb2");
        unit2.setContents(contents2);

        units.add(unit2);

        form.setUnits(units);


        formService.createForm(form);



    }
}
