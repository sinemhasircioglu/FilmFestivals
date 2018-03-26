package dao;

import entities.Multimedya;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class MultimedyaDAO {

    public Multimedya find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Multimedya multimedya = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Multimedya\" WHERE id=" + id + "");

            if (rs.next()) {
                multimedya = new Multimedya();
                multimedya.setId(rs.getInt("id"));
                multimedya.setUrl(rs.getString("url"));
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultimedyaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return multimedya;
    }

}
