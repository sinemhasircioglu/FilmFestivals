/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Films;
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
public class FilmDAO {
    private ActorDAO actordao;
    private UserDAO userdao;
    private JuryDAO jurydao;
    private MusicDAO musicdao;
    
    public List<Films> list() {
        List<Films> filmlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Films\"");        
            while (rs.next()) {
                Films film = new Films();
                film.setFilmid(rs.getInt("id"));
                film.setFilmname(rs.getString("name"));
                film.setActorList(this.actordao.list());
                film.setUserlist(this.userdao.list());
                film.setFestivalid(rs.getInt("festivalid"));
                film.setGenre(rs.getString("genre"));
                film.setFileId(rs.getInt("fileid"));
                filmlist.add(film);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return filmlist;
    }

    public Films detail(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        Films film = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Films\" WHERE id=" + id + "");
            rs.next();
            film = new Films();
            film.setFilmid(rs.getInt("id"));
            film.setFilmname(rs.getString("name"));
            film.setActorList(this.getActordao().list());
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return film;
    }

    public ActorDAO getActordao() {
        if(this.actordao==null)
            this.actordao=new ActorDAO();
        return actordao;
    }

    public void setActordao(ActorDAO actordao) {
        this.actordao = actordao;
    }

    public UserDAO getUserdao() {
        if(this.userdao==null)
            this.userdao=new UserDAO();
        return userdao;
    }

    public void setUserdao(UserDAO userdao) {
        this.userdao = userdao;
    }

    public JuryDAO getJurydao() {
        if(this.jurydao==null)
            this.jurydao=new JuryDAO();
        return jurydao;
    }

    public void setJurydao(JuryDAO jurydao) {
        this.jurydao = jurydao;
    }

    public MusicDAO getMusicdao() {
        if(this.musicdao==null)
            this.musicdao=new MusicDAO();
        return musicdao;
    }

    public void setMusicdao(MusicDAO musicdao) {
        this.musicdao = musicdao;
    }
    
}
