
package entities;

/**
 *
 * @author sinem
 */
public class FilmUserRates {
    private int filmid;
    private int userid;
    private int rate;

    public FilmUserRates() {
    }

    public FilmUserRates(int filmid, int userid, int rate) {
        this.filmid = filmid;
        this.userid = userid;
        this.rate = rate;
    }
    
    

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "FilmUserRates{" + "filmid=" + filmid + ", userid=" + userid + ", rate=" + rate + '}';
    }
}
