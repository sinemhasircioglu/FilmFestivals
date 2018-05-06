package dao;

import entities.Directors;
import entities.Films;
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
public class FilmDAO extends AbstractDAO{

    private ActorDAO actorDao;
    private MusicDAO musicDao;
    private FestivalDAO festivalDao;
    private MultimedyaDAO multimedyaDao;
    private DirectorDAO directorDao;

    public void insert(Films film) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Films\"(name,genre,fileid,festivalid) VALUES('" + film.getName() + "','" + film.getGenre() + "'," + film.getMultimedya().getId() + "," + film.getFestival().getId() + ") ",PreparedStatement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();

            Long filmId = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) 
                filmId = gk.getLong(1);
            
            for(Directors d : film.getFilmDirectors()) {
                PreparedStatement pst2 = this.getConnection().prepareStatement("INSERT INTO public.\"FilmDirector\"(filmid,directorid) VALUES("+filmId+","+d.getId()+")");
                pst2.executeUpdate();                
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Films> findAll() {
        List<Films> filmList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Films\"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Films film = new Films();
                film.setId(rs.getLong("id"));
                film.setName(rs.getString("name"));
                film.setGenre(rs.getString("genre"));

                film.setFilmActors(this.getActorDao().getFilmActors(film.getId()));
                film.setFestival(this.getFestivalDao().find(rs.getLong("festivalid")));
                film.setFile(this.getMultimedyaDao().find(rs.getLong("fileid")));
                film.setFilmDirectors(this.getDirectorDao().getFilmDirectors(film.getId()));
                film.setFilmMusics(this.getMusicDao().getFilmMusics(film.getId()));
                filmList.add(film);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmList;
    }

    public List<Films> getDirectorFilms(Long directorid) {
        List<Films> directorFilms = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"FilmDirector\" WHERE directorid=" + directorid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                directorFilms.add(this.find(rs.getLong("filmid")));
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return directorFilms;
    }

    public List<Films> getFestivalFilms(Long festivalid) {
        List<Films> festivalFilms = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Films\" WHERE festivalid=" + festivalid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                festivalFilms.add(this.find(rs.getLong("id")));
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return festivalFilms;
    }

    public List<Films> getMultimedyaFilms(Long fileid) {
        List<Films> multimedyaFilms = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Films\" WHERE fileid=" + fileid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                multimedyaFilms.add(this.find(rs.getLong("id")));
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return multimedyaFilms;
    }

    public Films find(Long id) {
        Films film = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Films\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            film = new Films();
            film.setId(rs.getLong("id"));
            film.setName(rs.getString("name"));
            film.setGenre(rs.getString("genre"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return film;
    }

    public void delete(Films f) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"FilmDirector\" WHERE filmid=" + f.getId() + "");
            pst.executeUpdate();
            
            PreparedStatement pst2 = this.getConnection().prepareStatement("DELETE FROM public.\"Films\" WHERE id=" + f.getId() + "");
            pst2.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Films f) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Films\" SET name='" + f.getName() + "' , genre='" + f.getGenre() + "' WHERE id=" + f.getId() + " ");
            pst.executeUpdate();
            
            PreparedStatement pst2 = this.getConnection().prepareStatement("DELETE FROM public.\"FilmDirector\" WHERE filmid=" + f.getId() + "");
            pst2.executeUpdate();
            for(Directors d : f.getFilmDirectors()) {
                PreparedStatement pst3 = this.getConnection().prepareStatement("INSERT INTO public.\"FilmDirector\"(filmid,directorid) VALUES("+f.getId()+","+d.getId()+")");
                pst3.executeUpdate();                
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FestivalDAO.class.getName()).log(Level.SEVERE, null, ex);
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
