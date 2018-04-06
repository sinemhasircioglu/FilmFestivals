package dao;

import entities.Juries;
import java.sql.Connection;
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
public class JuryDAO {

    private MultimedyaDAO multimedyaDao;
    private FestivalDAO festivalDao;

    public void create(Juries j, int selectedFestival, int selectedMultimedya) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Juries\"(name,festivalid,fileid) VALUES ('" + j.getName() + "',"+selectedFestival+","+selectedMultimedya+")");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Juries> findAll() {
        List<Juries> juryList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Juries\"");
            while (rs.next()) {
                Juries j = new Juries();
                j.setId(rs.getInt("id"));
                j.setName(rs.getString("name"));
                j.setFestival(this.getFestivalDao().find(rs.getInt("festivalid")));
                j.setMultimedya(this.getMultimedyaDao().find(rs.getInt("fileid")));
                juryList.add(j);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return juryList;
    }

    public List<Juries> getFestivalJuries(int festivalid) {
        List<Juries> festivalFilms = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Juries\" WHERE festivalid=" + festivalid + "");
            while (rs.next()) {
                Juries j = new Juries();
                j.setId(rs.getInt("id"));
                j.setName(rs.getString("name"));
                festivalFilms.add(j);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return festivalFilms;

    }

    public Juries find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Juries jury = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Juries\" WHERE id=" + id + "");
            rs.next();
            jury = new Juries();
            jury.setId(rs.getInt("id"));
            jury.setName(rs.getString("name"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jury;
    }

    public void update(Juries j) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE public.\"Juries\" WHERE id="+j.getId()+" SET name='" + j.getName() + "' ");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Juries j) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Juries\" WHERE id=" + j.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MultimedyaDAO getMultimedyaDao() {
        if (this.multimedyaDao == null) {
            this.multimedyaDao = new MultimedyaDAO();
        }
        return multimedyaDao;
    }

    public FestivalDAO getFestivalDao() {
        if (this.festivalDao == null) {
            this.festivalDao = new FestivalDAO();
        }
        return festivalDao;
    }
}