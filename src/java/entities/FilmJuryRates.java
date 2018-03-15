
package entities;

/**
 *
 * @author sinem
 */
public class FilmJuryRates {
    private int filmid;
    private int juryid;
    private int rate;

    public FilmJuryRates() {
    }

    public FilmJuryRates(int filmid, int juryid, int rate) {
        this.filmid = filmid;
        this.juryid = juryid;
        this.rate = rate;
    }
    
    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public int getJuryid() {
        return juryid;
    }

    public void setJuryid(int juryid) {
        this.juryid = juryid;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "FilmJuryRates{" + "filmid=" + filmid + ", juryid=" + juryid + ", rate=" + rate + '}';
    }
}
