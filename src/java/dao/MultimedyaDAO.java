package dao;

import entities.Multimedya;
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
public class MultimedyaDAO {
    
    private ActorDAO actorDao;
    private UserDAO userDao;
    private DirectorDAO directorDao;
    private JuryDAO juryDao;
    private FilmDAO filmDao;

    public List<Multimedya> findAll() {
        List<Multimedya> multimedyaList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Multimedya\"");
            while (rs.next()) {
                Multimedya med = new Multimedya();
                med.setId(rs.getInt("id"));
                med.setUrl(rs.getString("url"));
                multimedyaList.add(med);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaList;
    }
    
    public Multimedya find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Multimedya multimedya = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Multimedya\" WHERE id=" + id + "");

            if (rs.next()) {
                multimedya = new Multimedya();
                multimedya.setId(rs.getInt("id"));
                multimedya.setUrl(rs.getString("url"));
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultimedyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return multimedya;
    }
    
    public void delete(Multimedya m) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Multimedya\" WHERE id=" + m.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultimedyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ActorDAO getActorDao() {
        if (this.actorDao == null) 
            this.actorDao = new ActorDAO();
        return actorDao;
    }

    public UserDAO getUserDao() {
        if(this.userDao==null)
            this.userDao=new UserDAO();
        return userDao;
    }

    public DirectorDAO getDirectorDao() {
        if (this.directorDao == null) 
            this.directorDao = new DirectorDAO();
        return directorDao;
    }

    public JuryDAO getJuryDao() {
        if (this.juryDao == null) 
            this.juryDao = new JuryDAO();
        return juryDao;
    }

    public FilmDAO getFilmDao() {
        if (this.filmDao == null) 
            this.filmDao = new FilmDAO();
        return filmDao;
    }

}
