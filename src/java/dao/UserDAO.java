package dao;

import entities.Users;
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
public class UserDAO {

    public void create(Users u) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Users\"(email,password,profileid) VALUES ('" + u.getEmail() + "','" + u.getPassword() + "'," + u.getProfileId() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Users> list() {
        List<Users> userlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Users\""); // veritabanından veri çekerken kullanılır           
            while (rs.next()) {
                Users us = new Users(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getInt("profileid"));
                userlist.add(us);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userlist;
    }

    public Users detail(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Users user = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Users\" WHERE id=" + id + "");
            rs.next();
            user = new Users(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getInt("profileid"));
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void update(Users u) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Users\" SET email='" + u.getEmail() + "' , password='" + u.getPassword() + "' , profileid=" + u.getProfileId() + "");
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
