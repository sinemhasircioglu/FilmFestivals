package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Type {
    private int id;
    private String name;
    private List<Rates> rateList;

    public Type() {
    }

    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
