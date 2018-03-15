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
    public void create(Group group) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Group\"(authority,userid) VALUES ("+group.getAuthority()+","+group.getUserId()+" )");
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
     public List<Group> list() {
        List<Group> grouplist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Group\"");         
            while (rs.next()) {
                Group group= new Group(rs.getInt("id"),rs.getString("authority"),rs.getInt("userid"));
                grouplist.add(group);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return grouplist; 
    }
     
     public Group detail(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Group group = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Group\" WHERE id=" + id + "");
            rs.next();
            group = new Group(rs.getInt("id"),rs.getString("authority"),rs.getInt("userid"));
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }
     
     public void update(Group group) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("UPDATE public.\"Group\" SET authority="+group.getAuthority()+" , userid="+group.getUserId()+" ");
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void delete(Group group) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Group\" WHERE id="+group.getId()+"");
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
