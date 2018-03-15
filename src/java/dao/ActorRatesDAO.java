package dao;

import entities.ActorRates;
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
public class ActorRatesDAO {
    
    public void create(ActorRates acra) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("INSERT INTO public.\"ActorRates\"(actorid,juryid,rate) VALUES ("+acra.getActorId()+","+acra.getJuryId()+","+acra.getRate()+")");
        } catch (SQLException ex) {
            Logger.getLogger(ActorRatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
     public List<ActorRates> list() {
        List<ActorRates> actorratelist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"ActorRates\"");         
            while (rs.next()) {
                ActorRates ac= new ActorRates(rs.getInt("id"),rs.getInt("actorid"),rs.getInt("juryid"),rs.getInt("rate"));
                actorratelist.add(ac);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorratelist; 
    }
     
     public ActorRates detail(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        ActorRates actorrate = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"ActorRates\" WHERE id=" + id + "");
            rs.next();
            actorrate = new ActorRates(rs.getInt("id"),rs.getInt("actorid"),rs.getInt("juryid"),rs.getInt("rate"));
        } catch (SQLException ex) {
            Logger.getLogger(ActorRatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actorrate;
    }
     
     public void update(ActorRates acra) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("UPDATE public.\"ActorRates\" SET actorid="+acra.getActorId()+" , juryid="+acra.getJuryId()+" , rate="+acra.getRate()+"");
        } catch (SQLException ex) {
            Logger.getLogger(ActorRatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void delete(ActorRates acra) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("DELETE FROM public.\"ActorRates\" WHERE id="+acra.getId()+"");
        } catch (SQLException ex) {
            Logger.getLogger(ActorRatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
