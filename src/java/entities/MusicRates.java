
package entities;

/**
 *
 * @author sinem
 */
public class MusicRates {
    private int id;
    private int musicId;
    private int juryId;
    private int rate;

    public MusicRates() {
    }

    public MusicRates(int id, int musicId, int juryId, int rate) {
        this.id = id;
        this.musicId = musicId;
        this.juryId = juryId;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public int getJuryId() {
        return juryId;
    }

    public void setJuryId(int juryId) {
        this.juryId = juryId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
}
