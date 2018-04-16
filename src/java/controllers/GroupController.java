package controllers;

import dao.GroupDAO;
import dao.UserDAO;
import entities.Group;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value="groupController")
@SessionScoped
public class GroupController implements Serializable{
    private Group group;
    private GroupDAO groupDao;
    private List<Group> groupList;
    
    private UserDAO userDao;
    private List<Long> selectedUsers;
    private List<Users> userList;
    
    public String create() {
        this.getGroupDao().create(this.group,selectedUsers);
        return "group";
    }
    
    public String updateForm(Group g){
        this.group=g;
        this.selectedUsers=new ArrayList<>();
        for(Users u : this.group.getUserList()) {
            this.selectedUsers.add(u.getId());
        }
        return "group";
    }
    
    public String update() {
        this.getGroupDao().update(this.group,selectedUsers);
        return "group";
    }
    
    public String delete() {
        this.getGroupDao().delete(this.group);
        return "group";
    }
    
    public Group getGroup() {
        if(this.group==null)
            this.group=new Group();
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public UserDAO getUserDao() {
        if(this.userDao==null)
            this.userDao = new UserDAO();
        return userDao;
    }    

    public List<Long> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<Long> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public List<Users> getUserList() {
        this.userList = this.getUserDao().findAll();
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }
}
