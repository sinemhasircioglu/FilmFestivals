package dao;

import entities.Directors;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DirectorDAO {
    
    private MultimedyaDAO multimedyaDao;
    private FilmDAO filmDao;
    
    public void create(Directors d, Long selectedMultimedya, List<Long> selectedFilms){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Directors\"(name,fileid) VALUES ('" + d.getName() + "',"+selectedMultimedya+")",Statement.RETURN_GENERATED_KEYS);
            
            Long directorid=null;
            ResultSet gk=st.getGeneratedKeys();
            if(gk.next()){
                directorid=gk.getLong(1);
            }
            for(Long l : selectedFilms){
                Statement st2=c.createStatement();
                st2.executeUpdate("insert into director_film(directorid, filmid) values ("+directorid+","+l+")");              
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
    
    public Directors find(Long id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Directors director = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Directors\" WHERE id=" + id + "");
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

    public void update(Directors d,Long selectedMultimedya, List<Long> selectedFilms) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Directors\" SET name='" + d.getName() + "', fileid="+selectedMultimedya+" WHERE id="+d.getId()+" ");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Directors d) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Directors\" WHERE id=" + d.getId() + "");
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
