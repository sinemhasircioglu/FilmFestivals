package dao;

import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class UserDAO {

    private MultimedyaDAO multimedyaDao;
    private GroupDAO groupDao;

    public void create(Users u, int selectedMultimedya, int selectedGroup ) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Users\"(email,password,name,gender,fileid,groupid) VALUES ('" + u.getEmail() + "','" + u.getPassword() + "','" + u.getName() + "', '" + u.isGender() + "' ,"+selectedMultimedya+ ","+selectedGroup+ ")");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Users> findAll() {
        List<Users> userList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Users\"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users us = new Users();
                us.setEmail(rs.getString("email"));
                us.setGender(rs.getBoolean("gender"));
                us.setId(rs.getInt("id"));
                us.setName(rs.getString("name"));
                us.setPassword(rs.getString("password"));

                us.setMultimedya(this.getMultimedyaDao().find(rs.getInt("fileid")));
                us.setGroup(this.getGroupDao().find(rs.getInt("groupid")));
                userList.add(us);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public Users find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Users user = null;
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Users\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            user = new Users();
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getBoolean("gender"));
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public List<Users> getGroupUsers(int groupid) {

        List<Users> groupUsers = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Users\" WHERE groupid=" + groupid + "");
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getBoolean("gender"));
                user.setPassword(rs.getString("password"));
                groupUsers.add(user);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupUsers;

    }

    public void update(Users u,int selectedMultimedya, int selectedGroup ) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Users\" SET email='" + u.getEmail() + "' , password='" + u.getPassword() + "' , name='" + u.getName() + "', gender='" + u.isGender() + "' ,fileid="+selectedMultimedya+", groupid="+selectedGroup+"");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Users u) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Users\" WHERE id=" + u.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MultimedyaDAO getMultimedyaDao() {
        if (this.multimedyaDao == null) {
            this.multimedyaDao = new MultimedyaDAO();
        }
        return multimedyaDao;
    }

    public GroupDAO getGroupDao() {
        if (this.groupDao == null) {
            this.groupDao = new GroupDAO();
        }
        return groupDao;
    }

}
