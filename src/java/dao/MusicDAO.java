package dao;

import entities.Musics;
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
public class MusicDAO {
    
    private FilmDAO filmDao;

    public void create(Musics m) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("INSERT INTO public.\"Musics\"(name,filmid) VALUES ('" + m.getName() + "'," + m.getFilm().getId() + ")");
            pst.executeUpdate();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(MusicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Musics> findAll() {
        List<Musics> musicList = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Musics\"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musics mu = new Musics();
                mu.setId(rs.getLong("id"));
                mu.setName(rs.getString("name"));
                mu.setFilm(this.getFilmDao().find(rs.getLong("filmid")));
                musicList.add(mu);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return musicList;
    }
    
    public Musics find(Long id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Musics mu =null;
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Musics\" WHERE id="+id+"");
            ResultSet rs = pst.executeQuery();
            rs.next();
            mu = new Musics();
            mu.setId(rs.getLong("id"));
            mu.setName(rs.getString("name"));
            c.close();                    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mu;
    }

    public List<Musics> getFilmMusics(Long filmid) {
        List<Musics> filmMusics = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"Musics\" WHERE filmid=" + filmid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musics ac = new Musics();
                ac.setId(rs.getLong("id"));
                ac.setName(rs.getString("name"));
                filmMusics.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmMusics;
    }

    public void update(Musics m) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("UPDATE public.\"Musics\" SET name='" + m.getName() + "' , filmid=" + m.getFilm().getId() + " WHERE id=" + m.getId() + " ");
            pst.executeUpdate();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Musics m) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("DELETE FROM public.\"Musics\" WHERE id=" + m.getId() + "");
            pst.executeUpdate();
            c.close();
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
