package dao;

import entities.Type;
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
public class TypeDAO {
    
    private RatesDAO ratesDao;
    
        public void create(Type type, List<Long> selectedRates) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO public.\"Type\"(name) VALUES (" + type.getName() + ")");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Type> findAll() {
        List<Type> typeList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Type\"");
            while (rs.next()) {
                Type type = new Type();
                type.setId(rs.getLong("id"));
                type.setName(rs.getString("name"));
                type.setRateList(this.getRatesDao().getTypeRates(rs.getLong("typeraterid")));
                typeList.add(type);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return typeList;
    }

    public Type find(Long id){
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Type type = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Type\" WHERE id=" + id + "");
            rs.next();
            type = new Type();
            type.setId(rs.getLong("id"));
            type.setName(rs.getString("name"));
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
    
        public void update(Type type, List<Long> selectedRates) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst;
            pst = c.prepareStatement("UPDATE public.\"Type\" SET name='" + type.getName() + "' WHERE id=" + type.getId() + " ");
            pst.executeUpdate();

            for (Long l : selectedRates) {
                pst = c.prepareStatement("UPDATE public.\"Rates\" SET typeraterid=" +type.getId()+ " WHERE id=" +Long.valueOf(l)+ " ");
                pst.executeUpdate();
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Type t) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM public.\"Type\" WHERE id=" + t.getId() + "");
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RatesDAO getRatesDao() {
        if(this.ratesDao==null)
            this.ratesDao=new RatesDAO();
        return ratesDao;
    }
    
}
