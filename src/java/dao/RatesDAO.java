package dao;

import entities.Rates;
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
public class RatesDAO {
    
    private TypeDAO typeDao;
    
    public List<Rates> findAll() {
        List<Rates> rateList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Rates\"");
            while (rs.next()) {
                Rates rate = new Rates();
                rate.setId(rs.getInt("id"));
                rate.setRate(rs.getInt("rate"));
                rate.setRaterType(this.getTypeDao().find(rs.getInt("raterid")));
                rate.setRatedType(this.getTypeDao().find(rs.getInt("raterid")));
                rateList.add(rate);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rateList;
    }
    
    public List<Rates> getTypeRates(int typeid){
        List<Rates> typeRates = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Rates\" WHERE typeratedid="+typeid+"");
            while (rs.next()) {
                Rates rate = new Rates();
                rate.setId(rs.getInt("id"));
                rate.setRate(rs.getInt("rate"));         
                typeRates.add(rate);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return typeRates;
    }
    
    public Rates find(int id){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Rates rate = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Rates\" WHERE id=" + id + "");
            rs.next();
            rate = new Rates();
            rate.setId(rs.getInt("id"));
            rate.setRate(rs.getInt("rate"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rate;
    }

    public void delete(Rates r) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Rates\" WHERE id=" + r.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TypeDAO getTypeDao() {
        if(this.typeDao==null)
            this.typeDao=new TypeDAO();
        return typeDao;
    }
    
}