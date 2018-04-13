package dao;

import entities.Group;
import java.sql.Connection;
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
public class GroupDAO {
    
    private UserDAO userDao;

    public void create(Group group) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Group\"(authority) VALUES (" + group.getAuthority() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Group> findAll() {
        List<Group> groupList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Group\"");
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getLong("id"));
                group.setAuthority(rs.getString("authority"));
                group.setUserList(this.getUserDao().getGroupUsers(group.getId()));
                groupList.add(group);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupList;
    }
    
    public Group find(Long id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Group group = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Group\" WHERE id=" + id + "");
            rs.next();
            group = new Group();
            group.setId(rs.getLong("id"));
            group.setAuthority(rs.getString("authority"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

    public void update(Group group) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Group\" SET authority=" + group.getAuthority() + "  ");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Group group) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Group\" WHERE id=" + group.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserDAO getUserDao() {
        if(this.userDao==null)
            this.userDao=new UserDAO();
        return userDao;
    }
    
}
