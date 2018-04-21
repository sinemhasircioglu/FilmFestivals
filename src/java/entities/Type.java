package entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author sinem
 */
public class Type {
    private Long id;
    private String name;
    private List<Rates> typeRates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rates> getTypeRates() {
        return typeRates;
    }

    public void setTypeRates(List<Rates> typeRates) {
        this.typeRates = typeRates;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Type other = (Type) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
