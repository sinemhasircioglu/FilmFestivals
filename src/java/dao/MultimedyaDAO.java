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

    private FilmDAO filmDao;

    public void create(Multimedya med) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Multimedya\"(name,path,type,filmid) VALUES ('" + med.getName()+ "','" + med.getPath()+ "','" + med.getType()+ "'," + med.getFilm().getId() + ")");
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
                med.setName(rs.getString("name"));
                med.setPath(rs.getString("path"));
                med.setType(rs.getString("type"));
                med.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
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
                med.setName(rs.getString("name"));
                med.setPath(rs.getString("path"));
                med.setType(rs.getString("type"));
                med.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
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
                multimedya.setName(rs.getString("name"));
                multimedya.setPath(rs.getString("path"));
                multimedya.setType(rs.getString("type"));
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultimedyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return multimedya;
    }
    
    public void update(Multimedya med) {
        try {
            PreparedStatement pst= this.getConnection().prepareStatement("UPDATE public.\"Multimedya\" SET name='" + med.getName() + "',path='" + med.getPath() + "',type='" + med.getType() + "', filmid="+med.getFilm().getId()+" WHERE id=" + med.getId() + " ");
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

    public FilmDAO getFilmDao() {
        if (this.filmDao == null) 
            this.filmDao = new FilmDAO();
        return filmDao;
    }
}
