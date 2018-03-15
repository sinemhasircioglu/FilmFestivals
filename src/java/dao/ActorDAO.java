package dao;
import entities.Actors;
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
public class ActorDAO {
    
    private JuryDAO jurydao;
    
    public void create(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Actors\"(name,gender,filmid,fileid) VALUES ('"+ac.getName()+"','"+ac.isGender()+"',"+ac.getFilmId()+"," +ac.getFileId()+")");
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public List<Actors> list() {
        List<Actors> actorlist=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\"");          
            while (rs.next()) {
                Actors ac= new Actors(rs.getInt("id"),rs.getString("name"),rs.getBoolean("gender"),rs.getInt("filmid"),rs.getInt("fileid"));
                actorlist.add(ac);
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorlist; 
    }
    
    public Actors detail(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Actors actor = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\" WHERE id=" + id + "");
            rs.next();
            actor = new Actors(rs.getInt("id"),rs.getString("name"),rs.getBoolean("gender"),rs.getInt("filmid"),rs.getInt("fileid"));
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actor;
    }
    
    public void update(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("UPDATE public.\"Actors\" SET name='"+ac.getName()+"' , gender='"+ac.isGender()+"' , filmid="+ac.getFilmId()+", fileid="+ac.getFileId()+"");
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void delete(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();    
        try {
            Statement st= c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Actors\" WHERE id="+ac.getId()+"");
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public JuryDAO getJurydao() {
        if(this.jurydao==null)
            this.jurydao=new JuryDAO();
        return jurydao;
    }

    public void setJurydao(JuryDAO jurydao) {
        this.jurydao = jurydao;
    }
    
}
