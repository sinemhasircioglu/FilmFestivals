package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Juries {
    private int id;
    private String name;
    private Festivals festival;
    private Multimedya multimedya;

    public Juries() {
    }

    public Juries(int id, String name) {
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

    public Festivals getFestival() {
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
    }

    public Multimedya getFile() {
        return multimedya;
    }

    public void setFile(Multimedya multimedya) {
        this.multimedya = multimedya;
    }

    @Override
    public String toString() {
        return "Juries{" + "id=" + id + ", name=" + name + ", festival=" + festival + ", multimedya=" + multimedya + '}';
    }

}
