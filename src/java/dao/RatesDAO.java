package dao;

import entities.Rates;
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
public class RatesDAO extends AbstractDAO {

    private TypeDAO typeDao;

    public void create(Rates r, Long selectedRaterType, Long selectedRatedType) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Rates\"(typeraterid,raterid,typeratedid,ratedid) VALUES (" + selectedRaterType + "," + selectedRatedType + ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Rates> findAll() {
        List<Rates> rateList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Rates\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Rates rate = new Rates();
                rate.setId(rs.getLong("id"));
                rate.setRate(rs.getInt("rate"));
                rate.setRaterType(this.getTypeDao().find(rs.getLong("raterid")));
                rate.setRatedType(this.getTypeDao().find(rs.getLong("raterid")));
                rateList.add(rate);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rateList;
    }
    
    public List<Rates> findAll(int page, int pageSize) {
        List<Rates> rateList = new ArrayList<>();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Rates\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Rates rate = new Rates();
                rate.setId(rs.getLong("id"));
                rate.setRate(rs.getInt("rate"));
                rate.setRaterType(this.getTypeDao().find(rs.getLong("raterid")));
                rate.setRatedType(this.getTypeDao().find(rs.getLong("raterid")));
                rateList.add(rate);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rateList;
    }

    public List<Rates> getTypeRates(Long typeid) {
        List<Rates> typeRates = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Rates\" WHERE typeratedid=" + typeid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Rates rate = new Rates();
                rate.setId(rs.getLong("id"));
                rate.setRate(rs.getInt("rate"));
                typeRates.add(rate);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return typeRates;
    }

    public Rates find(Long id) {
        Rates rate = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Rates\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            rate = new Rates();
            rate.setId(rs.getLong("id"));
            rate.setRate(rs.getInt("rate"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rate;
    }

    public void update(Rates r, Long selectedType) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("UPDATE public.\"Rates\" SET WHERE id=" + r.getId() + " ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Rates r) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Rates\" WHERE id=" + r.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TypeDAO getTypeDao() {
        if (this.typeDao == null) {
            this.typeDao = new TypeDAO();
        }
        return typeDao;
    }
}
