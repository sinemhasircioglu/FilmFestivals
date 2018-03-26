package dao;

import entities.Directors;
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
public class DirectorDAO {
    
    public List<Directors> getFilmDirectors(int filmid){      
        List<Directors> filmDirectors = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM public.\"FilmDirector\" WHERE directorid=" + filmid+ "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                filmDirectors.add(this.find(rs.getInt("directorid")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmDirectors;
    }   
    
    public Directors find(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Directors director = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Directors\" WHERE id=" + id + "");
            rs.next();
            director = new Directors();
            director.setId(rs.getInt("id"));
            director.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return director;
    }
}
