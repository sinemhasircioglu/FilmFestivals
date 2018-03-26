package dao;


import entities.Films;
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
public class FilmDAO {

    private ActorDAO actorDao;
    private MusicDAO musicDao;
    private FestivalDAO festivalDao;
    private MultimedyaDAO multimedyaDao;
    private DirectorDAO directorDao;

    public void insert(Films film) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Films\"(name,genre) VALUES('" + film.getName() + "','" + film.getGenre() + "') ");
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Films> findAll() {
        List<Films> filmList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Films\"");
            while (rs.next()) {
                Films film = new Films();
                film.setId(rs.getInt("id"));
                film.setName(rs.getString("name"));
                film.setGenre(rs.getString("genre"));

                film.setActorList(this.getActorDao().getFilmActors(film.getId()));
                film.setFestival(this.getFestivalDao().find(rs.getInt("festivalid")));
                film.setFile(this.getMultimedyaDao().find(rs.getInt("fileid")));
                film.setFilmDirectors(this.getDirectorDao().getFilmDirectors(film.getId()));
                film.setMusiclist(this.getMusicDao().getFilmMusics(film.getId()));
                filmList.add(film);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmList;
    }

    public List<Films> getDirectorFilms(int directorid) {
        List<Films> directorFilms = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"FilmDirector\" WHERE filmid=" + directorid + "");
            while (rs.next()) {
                directorFilms.add(this.find(rs.getInt("filmid")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return directorFilms;
    }

    public List<Films> getFestivalFilms(int festivalid) {
        List<Films> festivalFilms = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Films\" WHERE festivalid=" + festivalid + "");
            while (rs.next()) {
                Films film = new Films();
                film.setId(rs.getInt("id"));
                film.setName(rs.getString("name"));
                film.setGenre(rs.getString("genre"));

                festivalFilms.add(film);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return festivalFilms;
        
    }

    public Films find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Films film = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Films\" WHERE id=" + id + "");
            rs.next();
            film = new Films();
            film.setId(rs.getInt("id"));
            film.setName(rs.getString("name"));
            film.setGenre(rs.getString("genre"));

        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return film;
    }

    public void delete(Films f) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Films\" WHERE id=" + f.getId() + "");
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ActorDAO getActorDao() {
        if (this.actorDao == null) {
            this.actorDao = new ActorDAO();
        }
        return actorDao;
    }

    public MusicDAO getMusicDao() {
        if (this.musicDao == null) {
            this.musicDao = new MusicDAO();
        }
        return musicDao;
    }

    public FestivalDAO getFestivalDao() {
        if (this.festivalDao == null) {
            this.festivalDao = new FestivalDAO();
        }
        return festivalDao;
    }

    public MultimedyaDAO getMultimedyaDao() {
        if (this.multimedyaDao == null) {
            this.multimedyaDao = new MultimedyaDAO();
        }
        return multimedyaDao;
    }

    public DirectorDAO getDirectorDao() {
        if (this.directorDao == null) {
            this.directorDao = new DirectorDAO();
        }
        return directorDao;
    }
}
