package entities;

/**
 *
 * @author sinem
 */
public class Rates {
    private int id;
    private Type raterType;
    private Type retedType;
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

    public Type getRetedType() {
        return retedType;
    }

    public void setRetedType(Type retedType) {
        this.retedType = retedType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rates{" + "id=" + id + ", raterType=" + raterType + ", retedType=" + retedType + ", rate=" + rate + '}';
    }
    
}
