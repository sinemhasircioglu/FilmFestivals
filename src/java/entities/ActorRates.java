package entities;

/**
 *
 * @author sinem
 */
public class ActorRates {
    private int id;
    private int actorId;
    private int filmId;
    private int juryId;
    private int rate;

    public ActorRates(int id, int actorId, int filmId, int juryId, int rate) {
        this.id = id;
        this.actorId = actorId;
        this.filmId = filmId;
        this.juryId = juryId;
        this.rate = rate;
    }

    public ActorRates() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
