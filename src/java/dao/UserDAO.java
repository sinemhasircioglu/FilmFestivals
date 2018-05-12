package dao;

import entities.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinem
 */
public class UserDAO extends AbstractDAO{

    private GroupDAO groupDao;

    public void create(Users u) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Users\"(email,password,name,gender,groupid) VALUES ('" + u.getEmail() + "','" + u.getPassword() + "','" + u.getName() + "', '" + u.isGender() + "' ,"+u.getGroup().getId()+ ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void register(Users u) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Users\"(email,password,name) VALUES ('" + u.getEmail() + "','" + u.getPassword() + "','" + u.getName() + "')");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Users> findAll() {
        List<Users> userList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Users\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users us = new Users();
                us.setEmail(rs.getString("email"));
                us.setGender(rs.getBoolean("gender"));
                us.setId(rs.getLong("id"));
                us.setName(rs.getString("name"));
                us.setPassword(rs.getString("password"));
                us.setGroup(this.getGroupDao().find(rs.getLong("groupid")));
                userList.add(us);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public List<Users> findAll(int page, int pageSize) {
        List<Users> userList = new ArrayList<>();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Users\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users us = new Users();
                us.setEmail(rs.getString("email"));
                us.setGender(rs.getBoolean("gender"));
                us.setId(rs.getLong("id"));
                us.setName(rs.getString("name"));
                us.setPassword(rs.getString("password"));
                us.setGroup(this.getGroupDao().find(rs.getLong("groupid")));
                userList.add(us);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }
    
    public Users find(Long id) {
        Users user = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Users\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            user = new Users();
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getBoolean("gender"));
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public List<Users> getGroupUsers(Long groupid) {
        List<Users> groupUsers = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Users\" WHERE groupid=" + groupid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                groupUsers.add(this.find(rs.getLong("id")));
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupUsers;
    }

    public void update(Users u) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Users\" SET email='" + u.getEmail() + "' , password='" + u.getPassword() + "' , name='" + u.getName() + "', gender='" + u.isGender() + "' , groupid="+u.getGroup().getId()+" WHERE id="+u.getId()+" ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Users u) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Users\" WHERE id=" + u.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GroupDAO getGroupDao() {
        if (this.groupDao == null) {
            this.groupDao = new GroupDAO();
        }
        return groupDao;
    }
}
