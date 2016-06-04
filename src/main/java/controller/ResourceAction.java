package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import domain.Comment;
import domain.Form.Form;
import domain.Questionnaire.Questionnaire;
import domain.Resource.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.ResourceService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by cqx on 2016/5/25.
 */
public class ResourceAction extends ActionSupport{





/*
* resource search start
* */
    private String aoData;//resource.html dataTable info
    private List<Map> aaData;//data for dataTable handle by struts2
    public String getAoData() {
        return aoData;
    }
    public void setAoData(String aoData) {
        this.aoData = aoData;
    }
    public List<Map> getAaData() {
        return aaData;
    }
    public void setAaData(List<Map> aaData) {
        this.aaData = aaData;
    }

    public String formSearch() throws Exception{


        System.out.println("enter formSearch");

        List forms = select("Form");
        List<Map> resources = new ArrayList<Map>();
        for (int i = 0;i<6;i++){

            Form form = (Form) forms.get(i);
            Map obj = new HashMap<String,String>();
            obj.put("name",form.getFilename());
            obj.put("uploadDate",form.getCreateTime());
            obj.put("upload_user",form.getCreatorUserId());
            obj.put("reliablity",form.getReliability());
            obj.put("url",form.getUrl());
            resources.add(obj);
        }

        aaData = resources;
        return SUCCESS;
    }
    public String questionnaireSearch() throws Exception{

        System.out.println("enter questionnaireSearch");

        List questionnaires = select("Questionnaire");
        List<Map> resources = new ArrayList<Map>();
        for (int i = 0;i<6;i++){

            Questionnaire questionnaire = (Questionnaire) questionnaires.get(i);
            Map obj = new HashMap<String,String>();
            obj.put("name",questionnaire.getFilename());
            obj.put("uploadDate",questionnaire.getCreateTime());
            obj.put("upload_user",questionnaire.getCreatorUserId());
            obj.put("reliablity",questionnaire.getReliability());
            obj.put("url",questionnaire.getUrl());
            resources.add(obj);
        }
        aaData = resources;

        return SUCCESS;
    }
    public String coursewareSearch() throws Exception{

        System.out.println("enter coursewareSearch");

        List coursewares = select("Courseware");
        List<Map> resources = new ArrayList<Map>();
        for (int i = 0;i<6;i++){

            Courseware courseware = (Courseware) coursewares.get(i);
            Map obj = new HashMap<String,String>();
            obj.put("name",courseware.getFilename());
            obj.put("uploadDate",courseware.getCreateTime());
            obj.put("upload_user",courseware.getCreatorUserId());
            obj.put("reliablity",courseware.getReliability());
            obj.put("url",courseware.getUrl());
            resources.add(obj);
        }

        aaData = resources;

        return SUCCESS;
    }
    public String ebookSearch() throws Exception{

        System.out.println("enter ebookSearch");


        List eBooks = select("EBook");
        List<Map> resources = new ArrayList<Map>();
        for (int i = 0;i<eBooks.size();i++){

            EBook eBook = (EBook)eBooks.get(i);
            Map obj = new HashMap<String,String>();
            obj.put("name",eBook.getFilename());
            obj.put("uploadDate",eBook.getCreateTime());
            obj.put("upload_user",eBook.getCreatorUserId());
            obj.put("reliablity",eBook.getReliability());
            obj.put("url",eBook.getUrl());
            resources.add(obj);
        }
        aaData = resources;

        return SUCCESS;
    }
    public String paperSearch() throws Exception{

        System.out.println("enter paperSearch");

        List papers = select("Paper");
        List<Map> resources = new ArrayList<Map>();
        for (int i = 0;i<10;i++){

            Paper paper = (Paper)papers.get(i);
            Map obj = new HashMap<String,String>();
            obj.put("name",paper.getFilename());
            obj.put("uploadDate",paper.getCreateTime());
            obj.put("upload_user",paper.getCreatorUserId());
            obj.put("reliablity",paper.getReliability());
            obj.put("url",paper.getUrl());
            resources.add(obj);
        }

        aaData = resources;

        return SUCCESS;
    }

    public List select(String tableName) throws Exception{
        System.out.println("enter ResourceAction select !");
        String hql = "from "+tableName+" as e where 1=1 ";
        //System.out.println(filename+"666");

        Map request = (Map)ActionContext.getContext().get("request");
        filename = (String)request.get("filename");

        System.out.println(filename);
        creatorUserId = (String)request.get("creatorUserId");
        pointsFrom = (String)request.get("pointsFrom");
        pointsTo = (String)request.get("pointsTo");
        orderType = (String)request.get("orderType");

        if (filename != null&&!filename.equals("")){//

            hql+=" and e.filename like'"+filename+"%' ";
        }


        if(creatorUserId!=null&&!creatorUserId.equals("")){
            hql+=" and e.creatorUserId = '"+creatorUserId+"' ";
        }


        if(pointsFrom != null&&!pointsFrom.equals("")){
            hql+=" and e.pointsFrom >= "+pointsFrom;
        }


        if(pointsTo!=null&&!pointsTo.equals("")){
            hql+=" and e.pointsTo <= "+pointsTo;
        }


        if (orderType != null) {
            if (orderType.equals("choice")) {

            } else if (orderType.equals("reliability")) {
                hql += " order by e.reliability DESC";
            } else if (orderType.equals("date")) {
                hql += " order by e.createTime DESC";
            } else if (orderType.equals("points")) {
                hql += " order by e.points DESC";
            } else if (orderType.equals("downloads")) {
                hql += " order by e.downloads DESC";
            } else if (orderType.equals("likes")) {
                hql += " order by e.likes DESC";
            }
        }

        System.out.println("hql:"+hql);
        List<ResourceBase> eBooks = resourceService.getResourceByCondition(hql, ResourceType.ResourceType_EBOOK);

        return eBooks;
    }
    public String insert() throws Exception{
        System.out.println("enter ResourceAction!");
        if (filename == null){
            filename = (String)ActionContext.getContext().getParameters().get("filename");
        }
        if ((Integer)downloads == null){
            downloads = Integer.parseInt(ActionContext.getContext().getParameters().get("downloads").toString());
        }
        if (description == null){
            description = (String)ActionContext.getContext().getParameters().get("description");
        }

        if (typeOfEBookType == null){
            typeOfEBookType = (String)ActionContext.getContext().getParameters().get("typeOfEBookType");
        }
        EBook ebook = new EBook();
        ebook.setFilename(filename);
        ebook.setDownloads(downloads);
        ebook.setDescription("henhao");
        ebook.setTypeOfEBookType(typeOfEBookType);
        Date date = new Date();
        ebook.setCreateTime(date.toString());
        ebook.setCreatorUserId("1");
        ebook.setDescription("very good");
        resourceService.createResource(ebook, ResourceType.ResourceType_EBOOK);
        Map request = (Map)ActionContext.getContext().get("request");
        request.put("tip", "新增成功！！！");
        return SUCCESS;
    }

    //需要的属性,由struts负责赋值.
    private String filename;
    private int downloads;
    private  String description;
    private String typeOfEBookType;
    private String creatorUserId;
    private String pointsFrom;
    private String pointsTo;
    private String orderType;
    @Autowired
    ResourceService resourceService;
    public String getPointsFrom() { return pointsFrom;  }
    public void setPointsFrom(String pointsFrom) {  this.pointsFrom = pointsFrom;   }
    public String getPointsTo() {   return pointsTo;   }
    public void setPointsTo(String pointsTo) {  this.pointsTo = pointsTo;   }
    public String getOrderType() {return orderType;}
    public void setOrderType(String orderType) {this.orderType = orderType;}
    public String getCreatorUserId() {return creatorUserId;}
    public void setCreatorUserId(String creatorUserId) {this.creatorUserId = creatorUserId;}
    public ResourceService getResourceService() {return resourceService;}
    public void setResourceService(ResourceService resourceService) {this.resourceService = resourceService;}
    public int getDownloads() {return downloads;}
    public void setDownloads(int downloads) {this.downloads = downloads;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getTypeOfEBookType() {return typeOfEBookType;}
    public void setTypeOfEBookType(String typeOfEBookType) {this.typeOfEBookType = typeOfEBookType;}
    public String getFilename() {return filename;}
    public void setFilename(String filename) {this.filename = filename;}


/*
* resource search end
* */


    /*
    *  resource upload and download
    *
    * */
    //评论内容
    private String commentBody;
    //评论实体
    private Comment comment;
    //comment 的get set
    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    //commentbody 的get set
    public String getCommentBody() {
        return commentBody;
    }
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    @Autowired
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }






    private EBook eBook;
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private String savePath = "resource";

    private String points;

    public void setSavePath(String value)
    {
        if (value != null && !"".equals(value))
            this.savePath = value;
    }
    // 获取上传文件的保存位置
    private String getSavePath() throws Exception
    {
        return ServletActionContext.getServletContext()
                .getRealPath(savePath);
    }



    public EBook geteBook() {
        return eBook;
    }
    public void seteBook(EBook eBook) {
        this.eBook = eBook;
    }




    // upload的setter和getter方法
    public void setUpload(File upload)
    {
        this.upload = upload;
    }
    public File getUpload()
    {
        return (this.upload);
    }

    // uploadContentType的setter和getter方法
    public void setUploadContentType(String uploadContentType)
    {
        this.uploadContentType = uploadContentType;
    }
    public String getUploadContentType()
    {
        return (this.uploadContentType);
    }

    // uploadFileName的setter和getter方法
    public void setUploadFileName(String uploadFileName)
    {
        this.uploadFileName = uploadFileName;
    }
    public String getUploadFileName()
    {
        return (this.uploadFileName);
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    private String inputPath;
    // inputPath的setter方法
    public void setInputPath(String value)
    {
        inputPath = value;
    }


    public String getInputPath() {
        return inputPath;
    }

    /*
    定义一个返回InputStream的方法，
    该方法将作为被下载文件的入口，
    且需要配置stream类型结果时指定inputName参数，
    inputName参数的值就是方法去掉get前缀、首字母小写的字符串
    */
    //download function
    public InputStream getTargetFile() throws Exception
    {
        // ServletContext提供getResourceAsStream()方法
        // 返回指定文件对应的输入流
        return ServletActionContext.getServletContext()
                .getResourceAsStream(inputPath);
    }


    //upload function
    public String upload() throws Exception {
        System.out.println("enter upload !");
        savePath = description;
        // 以服务器的文件保存地址和原文件名建立上传文件输出流
        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        request.setCharacterEncoding("UTF-8");
        EBook eBook=new EBook();
        FileOutputStream fos = new FileOutputStream(getSavePath()
                + "-" + getUploadFileName());
        FileInputStream fis = new FileInputStream(getUpload());
        byte[] buffer = new byte[1024];
        int len = 0;

        System.out.println("well now ");
        while ((len = fis.read(buffer)) > 0)
        {

            fos.write(buffer , 0 , len);
        }


        System.out.println("well now ");
        fos.close();
        Date rdate=new Date();
        //String sdate;
        //sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(rdate);
        String url=getSavePath()
                + "-" + getUploadFileName();
        eBook.setCreateTime(rdate.toString());
        //这个属性需要修改
        eBook.setCreatorUserId("1");
        eBook.setDescription(description);
        eBook.setDislike(0);
        eBook.setDownloads(0);
        eBook.setFileSize(upload.length());
        eBook.setFilename(filename);
        eBook.setLikes(0);
        //这个属性需要修改
        eBook.setMd5("test");
        eBook.setPoints(0);
        if (points != null)
            eBook.setPoints(Integer.parseInt(points));
        eBook.setReliability(0);
        eBook.setTypeOfResourceType(ResourceType.ResourceType_EBOOK);
        eBook.setUrl(url);
        //这个属性需要修改
        eBook.setTypeOfEBookType("lishi");

        System.out.println("url now is "+url);

        resourceService.createResource(eBook, ResourceType.ResourceType_EBOOK);
        return "success";
    }



    private String downloadFileUrl;

    public String getDownloadFileUrl() {return downloadFileUrl;}
    public void setDownloadFileUrl(String downloadFileUrl) {this.downloadFileUrl = downloadFileUrl;}

    public void download() throws Exception{

        System.out.println("enter download !");

        ActionContext ctx = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);

//        return new FileInputStream(downloadFileUrl);
//        return ServletActionContext.getServletContext()
//                .getResourceAsStream(downloadFileUrl);
    }

    //comment search
    public String search(){
        System.out.println("aaa");
        List list=resourceService.getComments();
        Map request=(Map) ActionContext.getContext().get("request");
        request.put("list", list);
        //int flag=2;
        //request.put("flag", flag);

        return "showdata";


    }
    //comment create
    public String create(){
        Date commentDate = new Date();
        //String sdate;
        //sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(commentDate);
        comment.setCommentDate(commentDate);
        //comment.setUser(user);  这个是要添加的
        resourceService.createComment(comment);
        return "createdata";
    }
    public String show(){
        System.out.println("aaa");
        return "success";
    }







//    public String ebookSearch() throws IOException{
//
//        System.out.println("enter ebookSearch");
//        if (aoData == null){
//            aoData = (String) ActionContext.getContext().getParameters().get("aoData");
//        }
//
//        JSONArray aoDataArray = JSONArray.fromObject(aoData);
//
//        String sEcho = null;
//        int iDisplayStart = 0;
//        int iDisplayLength = 0;
//
//        for (int i = 0;i<aoDataArray.size();i++){
//
//            JSONObject obj = (JSONObject)aoDataArray.get(i);
//            if (obj.get("name").equals("sEcho"))
//                sEcho = obj.get("value").toString();
//            if (obj.get("name").equals("iDisplayStart")){
//                iDisplayStart = obj.getInt("value");
//            }
//            if (obj.get("name").equals("iDisplayLength")){
//                iDisplayLength = obj.getInt("value");
//            }
//        }
//
//
//        List<Map> resources = new ArrayList<Map>();
//        for (int i = 0;i<6;i++){
//
//            Map obj = new HashMap<String,String>();
//            obj.put("name","ebook"+i);
//            obj.put("uploadDate","2016-2-"+i);
//            obj.put("upload_user","u0"+i);
//            obj.put("reliablity","2-"+i);
//            resources.add(obj);
//        }
//
//        Map result = new HashMap<String,List>();
//        result.put("data",resources);
//
//        aaData = result;
//
//        return SUCCESS;
//    }
}
