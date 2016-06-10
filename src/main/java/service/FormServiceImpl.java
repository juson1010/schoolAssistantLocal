package service;

import dao.FormDao;
import dao.UnitDao;
import dao.UserDao;
import domain.Form.Form;
import domain.Form.FormType;
import domain.Unit;
import domain.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.io.Serializable;

/**
 * Created by cqx on 16/5/11.
 */
@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormDao formDao;
    @Autowired
    private UnitDao unitDao;
    @Autowired
    protected UserDao userDao;

    public Serializable createForm(Form form) {


        for (Unit item:form.getUnits()) {
            unitDao.save(item);
        }



        return formDao.save(form);

    }

    public Form getForm(String formNo) {
//        return null;
        return formDao.get(Form.class,Integer.parseInt(formNo));
    }

    public boolean updateForm(Form form) {

        for (Unit item:form.getUnits()) {
            unitDao.update(item);
        }


        formDao.update(form);
        return true;
    }

    public boolean deleteForm(Form form) {

        formDao.delete(form);
        return true;
    }

    public PageBean getFormsByUserId(String userId) {
        return null;
    }

    public PageBean getFormsByUserId(String userId, FormType type) {
        return null;
    }

    public PageBean getFormsByFormName(String formName) {
        return null;
    }

    public PageBean getFormsByFormName(String formName, FormType type) {
        return null;
    }

    public FormDao getFormDao() {return formDao;}

    public void setFormDao(FormDao formDao) {this.formDao = formDao;}

    public UnitDao getUnitDao() {
        return unitDao;
    }

    public void setUnitDao(UnitDao unitDao) {
        this.unitDao = unitDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
