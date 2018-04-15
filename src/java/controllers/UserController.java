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
    private Long selectedGroup;
    private List<Group> groupList;
    
    private MultimedyaDAO multimedyaDao;
    private Long selectedMultimedya;
    private List<Multimedya> multimedyaList;
   
    public String create() {
        this.getUserDao().create(this.user, selectedMultimedya, selectedGroup);
        return "user";
    }
    
    public String updateForm(Users u){
        this.user=u;
        this.selectedGroup=this.user.getGroup().getId();
        this.selectedMultimedya=this.user.getMultimedya().getId();
        return "user";
    }
    
    public String update() {
        this.getUserDao().update(this.user, selectedMultimedya, selectedGroup);
        return"user";
    }
    
    public String delete(Users u) {
        this.user=u;
        this.getUserDao().delete(this.user);
        return "user";
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

    public Long getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Long selectedGroup) {
        this.selectedGroup = selectedGroup;
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

    public Long getSelectedMultimedya() {
        return selectedMultimedya;
    }

    public void setSelectedMultimedya(Long selectedMultimedya) {
        this.selectedMultimedya = selectedMultimedya;
    }

    public List<Multimedya> getMultimedyaList() {
        this.multimedyaList=this.getMultimedyaDao().findAll();
        return multimedyaList;
    }

    public void setMultimedyaList(List<Multimedya> multimedyaList) {
        this.multimedyaList = multimedyaList;
    }
}
