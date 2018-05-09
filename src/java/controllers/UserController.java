package controllers;

import dao.GroupDAO;
import dao.UserDAO;
import entities.Group;
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
    private List<Users> fullUserList;

    private GroupDAO groupDao;
    private List<Group> groupList;
        
    private int page = 1;
    private int pageSize = 3;
    private List<Users> userList;
   
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
    
    public void previous() {
        if (this.page == 1) {
            this.page = this.pageCount();
        } else {
            this.page--;
        }
    }

    public void next() {
        if (this.page == this.pageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public int pageCount() {
        return (int) Math.ceil(this.getUserDao().findAll().size() / (double) pageSize);
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
        this.userList = this.getUserDao().findAll(page,pageSize);
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

    public List<Users> getFullUserList() {
        this.fullUserList=this.getUserDao().findAll();
        return fullUserList;
    }

    public void setFullUserList(List<Users> fullUserList) {
        this.fullUserList = fullUserList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
