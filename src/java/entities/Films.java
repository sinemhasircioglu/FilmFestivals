/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author sinem
 */

public class Films {

    private int filmid;
    private String filmname;
    private int festivalid;
    private String genre;
    private int directorid;

    public Films(int filmid, String filmname, int festivalid, String genre, int directorid) {
        this.filmid = filmid;
        this.filmname = filmname;
        this.festivalid = festivalid;
        this.genre = genre;
        this.directorid = directorid;
    }

    public Films() {
    }

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public int getFestivalid() {
        return festivalid;
    }

    public void setFestivalid(int festivalid) {
        this.festivalid = festivalid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDirectorid() {
        return directorid;
    }

    public void setDirectorid(int directorid) {
        this.directorid = directorid;
    }

    @Override
    public String toString() {
        return "Films{" + "filmid=" + filmid + ", filmname=" + filmname + ", festivalid=" + festivalid + ", genre=" + genre + ", directorid=" + directorid + '}';
    }
}
