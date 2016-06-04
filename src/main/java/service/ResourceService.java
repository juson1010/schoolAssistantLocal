package service;

import domain.Comment;
import domain.Resource.ResourceBase;
import domain.Resource.ResourceType;
import domain.Resource.SearchCondition;
import domain.User.User;
import util.PageBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cqx on 16/5/10.
 */
public interface ResourceService {

    boolean createResource(ResourceBase resource, ResourceType resourceType);

    /*确认有删除资源权限(资源拥有者)*/
    boolean deleteResource(ResourceBase resource, User user);

    boolean updateResource(ResourceBase resource, ResourceType resourceType);


    PageBean getResource(SearchCondition searchCondition);
    public ResourceBase getResourceById(int id , ResourceType resourceType);
    public List<ResourceBase> getResourceByCondition(String condition, ResourceType resourceType);




    void createComment(Comment comment);

    Comment getComment(int comment_id);

    void updateComment(Comment comment);

    void deleteComment(int comment_id);

    List getComments();


}
