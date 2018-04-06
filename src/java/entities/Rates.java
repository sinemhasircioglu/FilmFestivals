package entities;

/**
 *
 * @author sinem
 */
public class Rates {
    private int id;
    private Type raterType;
    private Type ratedType;
    private int rate;

    public Rates() {
    }

    public Rates(int id, int rate) {
        this.id = id;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getRaterType() {
        return raterType;
    }

    public void setRaterType(Type raterType) {
        this.raterType = raterType;
    }

    public Type getRatedType() {
        return ratedType;
    }

    public void setRatedType(Type ratedType) {
        this.ratedType = ratedType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rates{" + "id=" + id + ", raterType=" + raterType + ", ratedType=" + ratedType + ", rate=" + rate + '}';
    }
    
}
