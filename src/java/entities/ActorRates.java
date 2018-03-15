package entities;

/**
 *
 * @author sinem
 */
public class ActorRates {
    private int id;
    private int actorId;
    private int juryId;
    private int rate;

    public ActorRates(int id, int actorId, int juryId, int rate) {
        this.id = id;
        this.actorId = actorId;
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
