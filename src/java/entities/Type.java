package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Type {
    private Long id;
    private String name;
    private List<Rates> rateList;

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

    public List<Rates> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rates> rateList) {
        this.rateList = rateList;
    }

    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", name=" + name + ", rateList=" + rateList + '}';
    }

}
