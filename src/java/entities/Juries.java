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
    private File file;

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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Juries{" + "id=" + id + ", name=" + name + ", festival=" + festival + ", file=" + file + '}';
    }

}
