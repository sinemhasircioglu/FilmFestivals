package dao;

import entities.Musics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utility.DBConnection;

/**
 *
 * @author sinem
 */
public class MusicDAO {
    
    public List<Musics> findAll() {
        List<Musics> musicList=new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Musics\"");          
            while (rs.next()) {
                Musics mu= new Musics();
                mu.setId(rs.getInt("id"));
                mu.setName(rs.getString("name"));
                musicList.add(mu);
            }
            c.close();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return musicList; 
    }
    
     public List<Musics> getFilmMusics(int filmid){
        List<Musics> filmMusics = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Musics\" WHERE filmid="+filmid+"");
            while (rs.next()) {
                Musics ac = new Musics();
                ac.setId(rs.getInt("id"));
                ac.setName(rs.getString("name"));
                filmMusics.add(ac);
            }
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmMusics;
    }
}
