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

    private FilmDAO filmDao;
    private MultimedyaDAO multimedyaDao;
    
    public void create(Actors ac,Long selectedFilm,Long selectedMultimedya) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Actors\"(name,fileid,filmid) VALUES ('" + ac.getName() + "', "+selectedMultimedya+ ","+selectedFilm+ ")");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Actors> findAll() {
        List<Actors> actorList = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\"");
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                ac.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
                ac.setMultimedya(this.getMultimedyaDao().find(rs.getLong("fileid")));
                actorList.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorList;
    }

    public Actors find(Long id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Actors ac = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\" WHERE id=" + id + "");
            rs.next();
            ac = new Actors();
            ac.setId(rs.getLong("id"));
            ac.setName(rs.getString("name"));
            ac.setGender(rs.getBoolean("gender"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }
    
    public List<Actors> getFilmActors(Long filmid){
        List<Actors> filmActors = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\" WHERE filmid="+filmid+"");
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                filmActors.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmActors;
    }
    
    public List<Actors> getMultimedyaActors(Long fileid){
        List<Actors> multimedyaActors = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Actors\" WHERE fileid="+fileid+"");
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                multimedyaActors.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaActors;
    }
    
    public void update(Actors ac,Long selectedFilm,Long selectedMultimedya) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Actors\" SET name='" + ac.getName() + "' , gender='" + ac.isGender() + "',fileid="+selectedMultimedya+",filmid="+selectedFilm+" WHERE id="+ac.getId()+"");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Actors ac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Actors\" WHERE id=" + ac.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao=new MultimedyaDAO();
        return multimedyaDao;
    }
}
