package dao;
import entities.Actors;
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
public class ActorDAO {
    public List<Actors> getActors() {
        List<Actors> actorlist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\""); // veritabanından veri çekerken kullanılır           
            while (rs.next()) {
                Actors ac= new Actors(rs.getInt("id"),rs.getString("name"),rs.getBoolean("gender"),rs.getInt("filmid"));
                actorlist.add(ac);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorlist; 
    }
}
