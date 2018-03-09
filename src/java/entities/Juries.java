
package entities;

/**
 *
 * @author sinem
 */
public class Juries {
    private int id;
    private String name;
    private int festivalId;

    public Juries() {
    }

    public Juries(int id, String name, int festivalId) {
        this.id = id;
        this.name = name;
        this.festivalId = festivalId;
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

    public int getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }

}
