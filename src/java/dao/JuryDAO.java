package dao;

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
public class JuryDAO extends AbstractDAO{

    private FestivalDAO festivalDao;

    public void create(Juries j) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Juries\"(name,festivalid) VALUES ('" + j.getName() + "',"+j.getFestival().getId()+" ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Juries> findAll() {
        List<Juries> juryList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Juries\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Juries j = new Juries();
                j.setId(rs.getLong("id"));
                j.setName(rs.getString("name"));
                j.setFestival(this.getFestivalDao().find(rs.getLong("festivalid")));
                juryList.add(j);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return juryList;
    }
    
    public List<Juries> findAll(int page, int pageSize) {
        List<Juries> juryList = new ArrayList<>();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Juries\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Juries j = new Juries();
                j.setId(rs.getLong("id"));
                j.setName(rs.getString("name"));
                j.setFestival(this.getFestivalDao().find(rs.getLong("festivalid")));
                juryList.add(j);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return juryList;
    }

    public List<Juries> getFestivalJuries(Long festivalid) {
        List<Juries> festivalJuries = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Juries\" WHERE festivalid=" + festivalid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Juries j = new Juries();
                j.setId(rs.getLong("id"));
                j.setName(rs.getString("name"));
                festivalJuries.add(j);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return festivalJuries;

    }

    public Juries find(Long id) {
        Juries jury = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Juries\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            jury = new Juries();
            jury.setId(rs.getLong("id"));
            jury.setName(rs.getString("name"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jury;
    }

    public void update(Juries j) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Juries\" SET name='" + j.getName() + "' ,festivalid="+j.getFestival().getId()+" WHERE id="+j.getId()+" ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Juries j) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Juries\" WHERE id=" + j.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(JuryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FestivalDAO getFestivalDao() {
        if (this.festivalDao == null) {
            this.festivalDao = new FestivalDAO();
        }
        return festivalDao;
    }
}
