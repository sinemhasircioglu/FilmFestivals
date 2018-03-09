package dao;

import entities.Users;
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
public class UserDAO {
     public List<Users> getUsers() {
        List<Users> userlist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Users\""); // veritabanından veri çekerken kullanılır           
            while (rs.next()) {
                Users us= new Users(rs.getInt("id"),rs.getString("email"),rs.getString("password"),rs.getInt("profileid"));
                userlist.add(us);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userlist; 
    }
}
