package service;

import java.util.List;

import domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.*;
import domain.Form.Form;
import domain.Questionnaire.Questionnaire;
import domain.Resource.*;
import domain.User.User;
import util.PageBean;

/**
 * Created by cqx on 16/5/11.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private FormDao formDao;
    @Autowired
    private QuestionnaireDao questionnaireDao;
    @Autowired
    private EBookDao eBookDao;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private CoursewareDao coursewareDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;


    public boolean createResource(ResourceBase resource, ResourceType resourceType) {

        switch (resourceType){

            case ResourceType_COURSEWARE:

                coursewareDao.save((Courseware) resource);
                break;
            case ResourceType_EBOOK:

                eBookDao.save((EBook) resource);
                break;
            case ResourceType_FORM:

                formDao.save((Form) resource);
                break;
            case ResourceType_QUESTIONNAIRE:

                questionnaireDao.save((Questionnaire) resource);
                break;
        }
        return true;

    }


    /*
    * 查询资源是否由用户创建
    *
    * */
    public boolean deleteResource(ResourceBase resource, User user) {
        ResourceType type = resource.getTypeOfResourceType();
        User creator = userDao.get(User.class,  resource.getCreatorUserId());
        if (creator.getId() != user.getId()) return false;
        switch (type){

            case ResourceType_COURSEWARE:
                coursewareDao.delete((Courseware) resource);
                break;
            case ResourceType_EBOOK:

                eBookDao.delete((EBook) resource);
                break;
            case ResourceType_FORM:

                formDao.delete((Form) resource);
                break;
            case ResourceType_QUESTIONNAIRE:

                questionnaireDao.delete((Questionnaire) resource);
                break;
        }
        return true;

    }

    public boolean updateResource(ResourceBase resource, ResourceType resourceType) {


        switch (resourceType){

            case ResourceType_COURSEWARE:

                coursewareDao.update((Courseware) resource);
                break;
            case ResourceType_EBOOK:

                eBookDao.update((EBook) resource);
                break;
            case ResourceType_FORM:

                formDao.update((Form) resource);
                break;
            case ResourceType_QUESTIONNAIRE:

                questionnaireDao.update((Questionnaire) resource);
                break;
        }
        return true;
    }

    public PageBean getResource(SearchCondition searchCondition) {
        /*补充 */

        return null;
    }

    public ResourceBase getResourceById(int id , ResourceType resourceType) {
        ResourceBase resourceBase=null;
        switch (resourceType){

            case ResourceType_COURSEWARE:

                resourceBase =(ResourceBase)(coursewareDao.get(Courseware.class,id));
                break;
            case ResourceType_EBOOK:

                resourceBase =eBookDao.get(EBook.class,id);
                break;
            case ResourceType_FORM:

                resourceBase =formDao.get(Form.class,id);
                break;
            case ResourceType_QUESTIONNAIRE:

                resourceBase =questionnaireDao.get(Questionnaire.class,id);
                break;
        }

        return resourceBase;
    }

    public List getResourceByCondition(String condition,ResourceType resourceType){
        List results=null;
        switch (resourceType){

            case ResourceType_COURSEWARE:

                results =coursewareDao.find(condition);
                break;
            case ResourceType_EBOOK:

                results =eBookDao.find(condition);
                break;
            case ResourceType_FORM:

                results =formDao.find(condition);
                break;
            case ResourceType_QUESTIONNAIRE:

                results =questionnaireDao.find(condition);
                break;
        }
        return results;
    }

    public FormDao getFormDao() {
        return formDao;
    }

    public void setFormDao(FormDao formDao) {
        this.formDao = formDao;
    }

    public QuestionnaireDao getQuestionnaireDao() {
        return questionnaireDao;
    }

    public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    public EBookDao geteBookDao() {
        return eBookDao;
    }

    public void seteBookDao(EBookDao eBookDao) {
        this.eBookDao = eBookDao;
    }

    public PaperDao getPaperDao() {
        return paperDao;
    }

    public void setPaperDao(PaperDao paperDao) {
        this.paperDao = paperDao;
    }


    public CoursewareDao getCoursewareDao() {
        return coursewareDao;
    }


    public void setCoursewareDao(CoursewareDao coursewareDao) {
        this.coursewareDao = coursewareDao;
    }


    public UserDao getUserDao() {
        return userDao;
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }





    //以下代码为comment部分




    public void createComment(Comment comment) {
        commentDao.save(comment);

        // TODO Auto-generated method stub

    }

    public Comment getComment(int comment_id) {
        // TODO Auto-generated method stub
        return (Comment) commentDao.get(Comment.class, comment_id);
    }

    public void updateComment(Comment comment) {
        // TODO Auto-generated method stub
        Comment c=commentDao.get(Comment.class, comment.getId());
        c.setCommentBody(comment.getCommentBody());


    }

    public void deleteComment(int comment_id) {
        // TODO Auto-generated method stub
        commentDao.delete(Comment.class,comment_id);
    }

    public List getComments() {
        // TODO Auto-generated method stub
        System.out.println("aaaaaaaa");
        List list=commentDao.findComment();
        return list;

    }
}
