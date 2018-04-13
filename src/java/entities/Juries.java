package entities;

/**
 *
 * @author sinem
 */
public class Juries {
    private Long id;
    private String name;
    private Festivals festival;
    private Multimedya multimedya;

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

    public Festivals getFestival() {
        return festival;
    }

    public void setFestival(Festivals festival) {
        this.festival = festival;
    }

    public Multimedya getMultimedya() {
        return multimedya;
    }

    public void setMultimedya(Multimedya multimedya) {
        this.multimedya = multimedya;
    }
    
    @Override
    public String toString() {
        return "Juries{" + "id=" + id + ", name=" + name + ", festival=" + festival + ", multimedya=" + multimedya + '}';
    }

}
