package entities;

/**
 *
 * @author sinem
 */
public class Rates {
    private Long id;
    private Type raterType;
    private Type ratedType;
    private Long rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rates{" + "id=" + id + ", raterType=" + raterType + ", ratedType=" + ratedType + ", rate=" + rate + '}';
    }
    
}
