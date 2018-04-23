package controllers;

import dao.GroupDAO;
import dao.MultimedyaDAO;
import dao.UserDAO;
import entities.Group;
import entities.Multimedya;
import entities.Users;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="userController")
@SessionScoped
public class UserController implements Serializable{
    private Users user;
    private UserDAO userDao;
    private List<Users> userList;

    private GroupDAO groupDao;
    private List<Group> groupList;
    
    private MultimedyaDAO multimedyaDao;
    private List<Multimedya> multimedyaList;
   
    public void create() {
        this.getUserDao().create(this.user);
        this.clearForm();
    }
    
    public void updateForm(Users u){
        this.user=u;
    }
    
    public void clearForm() {
        this.user=new Users();
    }
    
    public void update() {
        this.getUserDao().update(this.user);
        this.clearForm();
    }
    
    public void delete() {
        this.getUserDao().delete(this.user);
        this.clearForm();
    }
    
    public Users getUser() {
        if(this.user==null)
            this.user=new Users();
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        if(this.userDao==null)
            this.userDao = new UserDAO();
        return userDao;
    }

    public List<Users> getUserList() {
        this.userList = this.getUserDao().findAll();
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }   

    public GroupDAO getGroupDao() {
        if(this.groupDao==null)
            this.groupDao = new GroupDAO();
        return groupDao;
    }  

    public List<Group> getGroupList() {
        this.groupList=this.getGroupDao().findAll();
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao= new MultimedyaDAO();
        return multimedyaDao;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }
}
