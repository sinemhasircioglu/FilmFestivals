package dao;

import entities.Musics;
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
public class MusicDAO extends AbstractDAO{
    
    private FilmDAO filmDao;

    public void create(Musics m) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Musics\"(name,filmid) VALUES ('" + m.getName() + "'," + m.getFilm().getId() + ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MusicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Musics> findAll() {
        List<Musics> musicList = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Musics\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musics mu = new Musics();
                mu.setId(rs.getLong("id"));
                mu.setName(rs.getString("name"));
                mu.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
                musicList.add(mu);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return musicList;
    }
    
    public List<Musics> findAll(int page, int pageSize) {
        List<Musics> musicList = new ArrayList();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Musics\" LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musics mu = new Musics();
                mu.setId(rs.getLong("id"));
                mu.setName(rs.getString("name"));
                mu.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
                musicList.add(mu);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return musicList;
    }
    
    public Musics find(Long id) {
        Musics mu =null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Musics\" WHERE id="+id+"");
            ResultSet rs = pst.executeQuery();
            rs.next();
            mu = new Musics();
            mu.setId(rs.getLong("id"));
            mu.setName(rs.getString("name"));
            pst.close();                    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mu;
    }

    public List<Musics> getFilmMusics(Long filmid) {
        List<Musics> filmMusics = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Musics\" WHERE filmid=" + filmid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musics ac = new Musics();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                filmMusics.add(ac);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmMusics;
    }

    public void update(Musics m) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Musics\" SET name='" + m.getName() + "' , filmid=" + m.getFilm().getId() + " WHERE id=" + m.getId() + " ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Musics m) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Musics\" WHERE id=" + m.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MusicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FilmDAO getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDAO();
        return filmDao;
    }
}
