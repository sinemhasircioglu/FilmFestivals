package dao;

import entities.ActorRates;
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
public class ActorRatesDAO {
     public List<ActorRates> getActorRates() {
        List<ActorRates> actorratelist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"ActorRates\""); // veritabanından veri çekerken kullanılır           
            while (rs.next()) {
                ActorRates ac= new ActorRates(rs.getInt("id"),rs.getInt("actorid"),rs.getInt("filmid"),rs.getInt("juryid"),rs.getInt("rate"));
                actorratelist.add(ac);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorratelist; 
    }
}
