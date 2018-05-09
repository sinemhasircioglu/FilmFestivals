package dao;

import entities.Actors;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinem
 */
public class ActorDAO extends AbstractDAO{

    private FilmDAO filmDao;
    private MultimedyaDAO multimedyaDao;
    
    public void create(Actors ac) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Actors\"(name,fileid,filmid) VALUES ('" + ac.getName() + "', "+ac.getMultimedya().getId()+ ","+ac.getFilm().getId()+ ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Actors> findAll() {
        List<Actors> actorList = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Actors\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                ac.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
                ac.setMultimedya(this.getMultimedyaDao().find(rs.getLong("fileid")));
                actorList.add(ac);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorList;
    }
    
    public List<Actors> findAll(int page,int pageSize) {
        List<Actors> actorList = new ArrayList();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Actors\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                ac.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
                ac.setMultimedya(this.getMultimedyaDao().find(rs.getLong("fileid")));
                actorList.add(ac);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return actorList;
    }

    public Actors find(Long id) {
        Actors ac = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Actors\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            ac = new Actors();
            ac.setId(rs.getLong("id"));
            ac.setName(rs.getString("name"));
            ac.setGender(rs.getBoolean("gender"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }
    
    public List<Actors> getFilmActors(Long filmid){
        List<Actors> filmActors = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Actors\" WHERE filmid="+filmid+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                filmActors.add(ac);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmActors;
    }
    
    public List<Actors> getMultimedyaActors(Long fileid){
        List<Actors> multimedyaActors = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Actors\" WHERE fileid="+fileid+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actors ac = new Actors();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                multimedyaActors.add(ac);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaActors;
    }
    
    public void update(Actors ac) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Actors\" SET name='" + ac.getName() + "' , gender='" + ac.isGender() + "',fileid="+ac.getMultimedya().getId()+",filmid="+ac.getFilm().getId()+" WHERE id="+ac.getId()+"");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Actors ac) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Actors\" WHERE id=" + ac.getId() + "");
            pst.executeUpdate();
            pst.close();
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
