package dao;

import entities.Profiles;
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
public class ProfilesDAO {
    
    public void create(Profiles p) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Profiles\"(name,birthday,userid,imageurl,gender) VALUES ('"+p.getName()+"', '"+p.getBirthday()+"' , "+p.getUserId()+",'"+p.getImageUrl()+"','"+p.isGender()+"' )");
        } catch (SQLException ex) {
            Logger.getLogger(ProfilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
     public List<Profiles> list() {
        List<Profiles> profilelist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Profiles\""); // veritabanından veri çekerken kullanılır           
            while (rs.next()) {
                Profiles pro = new Profiles(rs.getInt("id"),rs.getString("name"),rs.getDate("birthday"),rs.getInt("userid"),rs.getString("imageurl"),rs.getBoolean("gender"));
                profilelist.add(pro);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return profilelist; 
    }
     
     public void update(Profiles p) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("UPDATE public.\"Profiles\" SET name='"+p.getName()+"', birthday='"+p.getBirthday()+"', userid="+p.getUserId()+" , imageurl='"+p.getImageUrl()+"' , gender='"+p.isGender()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ProfilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void delete(Profiles p) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Profiles\" WHERE id="+p.getId()+"");
        } catch (SQLException ex) {
            Logger.getLogger(ProfilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
