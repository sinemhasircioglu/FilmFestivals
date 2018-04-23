package dao;

import entities.Directors;
import entities.Films;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class DirectorDAO {
    
    private MultimedyaDAO multimedyaDao;
    private FilmDAO filmDao;
    
    public void create(Directors d){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("INSERT INTO public.\"Directors\"(name,fileid) VALUES ('" + d.getName() + "',"+d.getMultimedya().getId()+")",PreparedStatement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            
            Long directorId = null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next())
                directorId = gk.getLong(1);
            
            for(Films f : d.getDirectorFilms()){
                PreparedStatement pst2=c.prepareStatement("INSERT INTO public.\"FilmDirector\"(filmid,directorid) VALUES("+f.getId()+","+directorId+")");
                pst2.executeUpdate();              
            }          
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Directors> getFilmDirectors(Long filmid){      
        List<Directors> filmDirectors = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"FilmDirector\" WHERE filmid=" + filmid+ "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                filmDirectors.add(this.find(rs.getLong("directorid")));
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmDirectors;
    }  
    
    public List<Directors> getMultimedyaDirectors(Long fileid){      
        List<Directors> multimedyaDirectors = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Directors\" WHERE fileid=" + fileid+ "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                multimedyaDirectors.add(this.find(rs.getLong("id")));
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaDirectors;
    }
    
    public Directors find(Long id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Directors director = null;
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Directors\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            director = new Directors();
            director.setId(rs.getLong("id"));
            director.setName(rs.getString("name"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return director;
    }
    
    public List<Directors> findAll() {
        List<Directors> directorList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Directors\" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Directors director = new Directors();
                director.setDirectorFilms(this.getFilmDao().getDirectorFilms(rs.getLong("id")));
                director.setId(rs.getLong("id"));
                director.setMultimedya(this.getMultimedyaDao().find(rs.getLong("fileid")));
                director.setName(rs.getString("name"));
                directorList.add(director);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return directorList;
    }

    public void update(Directors d) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("UPDATE public.\"Directors\" SET name='" + d.getName() + "', fileid="+d.getMultimedya().getId()+" WHERE id="+d.getId()+" ");
            pst.executeUpdate();
            
            PreparedStatement pst2 = c.prepareStatement("DELETE FROM public.\"FilmDirector\" WHERE directorid=" + d.getId() + "");
            pst2.executeUpdate();
            for(Films f : d.getDirectorFilms()) {
                PreparedStatement pst3 = c.prepareStatement("INSERT INTO public.\"FilmDirector\"(filmid,directorid) VALUES("+f.getId()+","+d.getId()+")");
                pst3.executeUpdate();                
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Directors d) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("DELETE FROM public.\"FilmDirector\" WHERE directorid=" + d.getId() + "");
            pst.executeUpdate();
            
            PreparedStatement pst2 = c.prepareStatement("DELETE FROM public.\"Directors\" WHERE id=" + d.getId() + "");
            pst2.executeUpdate();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MultimedyaDAO getMultimedyaDao() {
        if(this.multimedyaDao==null)
            this.multimedyaDao=new MultimedyaDAO();
        return multimedyaDao;
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }   
}
