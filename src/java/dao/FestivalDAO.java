package dao;

import entities.Festivals;
import entities.Films;
import entities.Juries;
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
public class FestivalDAO extends AbstractDAO{

    private JuryDAO juryDao;
    private FilmDAO filmDao;

    public void create(Festivals f) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Festivals\"(name,country,description,year) VALUES ('" + f.getName() + "','" + f.getCountry() + "','" + f.getDescription() + "'," + f.getYear() + ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FestivalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Festivals> findAll() {
        List<Festivals> festivalList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Festivals\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Festivals fest = new Festivals();
                fest.setId(rs.getLong("id"));
                fest.setName(rs.getString("name"));
                fest.setCountry(rs.getString("country"));
                fest.setDescription(rs.getString("description"));
                fest.setYear(rs.getInt("year"));
                fest.setFestivalFilms(this.getFilmDao().getFestivalFilms(fest.getId()));
                fest.setFestivalJuries(this.getJuryDao().getFestivalJuries(fest.getId()));
                festivalList.add(fest);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return festivalList;
    }
    
    public List<Festivals> findAll(int page, int pageSize) {
        List<Festivals> festivalList = new ArrayList<>();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Festivals\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Festivals fest = new Festivals();
                fest.setId(rs.getLong("id"));
                fest.setName(rs.getString("name"));
                fest.setCountry(rs.getString("country"));
                fest.setDescription(rs.getString("description"));
                fest.setYear(rs.getInt("year"));
                fest.setFestivalFilms(this.getFilmDao().getFestivalFilms(fest.getId()));
                fest.setFestivalJuries(this.getJuryDao().getFestivalJuries(fest.getId()));
                festivalList.add(fest);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return festivalList;
    }

    public Festivals find(Long id) {
        Festivals fest = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Festivals\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            fest = new Festivals();
            fest.setId(rs.getLong("id"));
            fest.setName(rs.getString("name"));
            fest.setCountry(rs.getString("country"));
            fest.setDescription(rs.getString("description"));
            fest.setYear(rs.getInt("year"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FestivalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fest;
    }

    public void update(Festivals f) {
        try {
            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("UPDATE public.\"Festivals\" SET name='" + f.getName() + "' , country='" + f.getCountry() + "', description='" + f.getDescription() + "', year=" + f.getYear() + " WHERE id=" + f.getId() + " ");
            pst.executeUpdate();

            for (Juries j : f.getFestivalJuries()) {
                pst = this.getConnection().prepareStatement("UPDATE public.\"Juries\" SET festivalid=" + f.getId()+ " WHERE id=" + j.getId()+ " ");
                pst.executeUpdate();
            }
            for (Films film : f.getFestivalFilms()) {
                pst = this.getConnection().prepareStatement("UPDATE public.\"Films\" SET festivalid=" + f.getId()+ " WHERE id=" + film.getId()+ " ");
                pst.executeUpdate();
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FestivalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Festivals fest) {
        try {
            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("DELETE FROM public.\"Festivals\" WHERE id=" + fest.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(FestivalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JuryDAO getJuryDao() {
        if (this.juryDao == null) {
            this.juryDao = new JuryDAO();
        }
        return juryDao;
    }

    public FilmDAO getFilmDao() {
        if (this.filmDao == null) {
            this.filmDao = new FilmDAO();
        }
        return filmDao;
    }
}
