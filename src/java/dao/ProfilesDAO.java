package dao;

import entities.Profiles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class ProfilesDAO {
     public List<Profiles> getProfiles() {
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
}
