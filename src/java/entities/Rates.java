package entities;

import java.util.Objects;

/**
 *
 * @author sinem
 */
public class Rates {
    private Long id;
    private Type raterType;
    private Type ratedType;
    private int rate;

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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rates other = (Rates) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
  
}
