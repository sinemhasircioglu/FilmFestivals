package dao;

import entities.Type;
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
public class TypeDAO extends AbstractDAO{
    
    private RatesDAO ratesDao;
    
        public void create(Type type, List<Long> selectedRates) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO public.\"Type\"(name) VALUES (" + type.getName() + ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RatesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Type> findAll() {
        List<Type> typeList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Type\" ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Type type = new Type();
                type.setId(rs.getLong("id"));
                type.setName(rs.getString("name"));
                type.setTypeRates(this.getRatesDao().getTypeRates(rs.getLong("typeraterid")));
                typeList.add(type);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return typeList;
    }
    
    public List<Type> findAll(int page, int pageSize) {
        List<Type> typeList = new ArrayList<>();
        int start=0;
        start= (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Type\" ORDER BY id LIMIT "+pageSize+" OFFSET "+start+" ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Type type = new Type();
                type.setId(rs.getLong("id"));
                type.setName(rs.getString("name"));
                type.setTypeRates(this.getRatesDao().getTypeRates(rs.getLong("typeraterid")));
                typeList.add(type);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return typeList;
    }

    public Type find(Long id){
        Type type = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("SELECT * FROM public.\"Type\" WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            type = new Type();
            type.setId(rs.getLong("id"));
            type.setName(rs.getString("name"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
    
        public void update(Type type, List<Long> selectedRates) {
        try {
            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("UPDATE public.\"Type\" SET name='" + type.getName() + "' WHERE id=" + type.getId() + " ");
            pst.executeUpdate();

            for (Long l : selectedRates) {
                pst = this.getConnection().prepareStatement("UPDATE public.\"Rates\" SET typeraterid=" +type.getId()+ " WHERE id=" +Long.valueOf(l)+ " ");
                pst.executeUpdate();
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Type t) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("DELETE FROM public.\"Type\" WHERE id=" + t.getId() + "");
            pst.executeUpdate();
            pst.close();
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
