package dao;

import entities.Multimedya;
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
public class MultimedyaDAO extends AbstractDAO{
    
    private ActorDAO actorDao;
    private UserDAO userDao;
    private DirectorDAO directorDao;
    private JuryDAO juryDao;
    private FilmDAO filmDao;

    public void create(Multimedya med) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Multimedya\"(url) VALUES ('" + med.getUrl()+ "')");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultimedyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Multimedya> findAll() {
        List<Multimedya> multimedyaList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Multimedya\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Multimedya med = new Multimedya();
                med.setId(rs.getLong("id"));
                med.setUrl(rs.getString("url"));
                med.setMultimedyaActors(this.getActorDao().getMultimedyaActors(med.getId()));
                med.setMultimedyaDirectors(this.getDirectorDao().getMultimedyaDirectors(med.getId()));
                med.setMultimedyaFilms(this.getFilmDao().getMultimedyaFilms(med.getId()));
                med.setMultimedyaJuries(this.getJuryDao().getFileJuries(med.getId()));
                med.setMultimedyaUsers(this.getUserDao().getFileUsers(med.getId()));
                multimedyaList.add(med);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaList;
    }
    
    public List<Multimedya> findAll(int page, int pageSize) {
        List<Multimedya> multimedyaList = new ArrayList<>();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Multimedya\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Multimedya med = new Multimedya();
                med.setId(rs.getLong("id"));
                med.setUrl(rs.getString("url"));
                med.setMultimedyaActors(this.getActorDao().getMultimedyaActors(med.getId()));
                med.setMultimedyaDirectors(this.getDirectorDao().getMultimedyaDirectors(med.getId()));
                med.setMultimedyaFilms(this.getFilmDao().getMultimedyaFilms(med.getId()));
                med.setMultimedyaJuries(this.getJuryDao().getFileJuries(med.getId()));
                med.setMultimedyaUsers(this.getUserDao().getFileUsers(med.getId()));
                multimedyaList.add(med);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaList;
    }
    
    public Multimedya find(Long id) {
        Multimedya multimedya = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Multimedya\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                multimedya = new Multimedya();
                multimedya.setId(rs.getLong("id"));
                multimedya.setUrl(rs.getString("url"));
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultimedyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return multimedya;
    }
    
    public void update(Multimedya med) {
        try {
            PreparedStatement pst= this.getConnection().prepareStatement("UPDATE public.\"Multimedya\" SET url='" + med.getUrl() + "' WHERE id=" + med.getId() + " ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Multimedya med) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Multimedya\" WHERE id=" + med.getId() + "");
            pst.executeUpdate();
            pst.close();
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
