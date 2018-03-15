package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Directors {

    private int id;
    private String name;
    private int fileId;
    private File file;
    private List<Juries> jurylist;
    private List<Films> filmlist;

    public Directors() {
    }

    public Directors(int id, String name, int fileId) {
        this.id = id;
        this.name= name;
        this.fileId = fileId;
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

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Juries> getJurylist() {
        return jurylist;
    }

    public void setJurylist(List<Juries> jurylist) {
        this.jurylist = jurylist;
    }

    public List<Films> getFilmlist() {
        return filmlist;
    }

    public void setFilmlist(List<Films> filmlist) {
        this.filmlist = filmlist;
    }

    @Override
    public String toString() {
        return "Directors{" + "id=" + id + ", name=" + name + ", fileId=" + fileId + ", file=" + file + ", jurylist=" + jurylist + ", filmlist=" + filmlist + '}';
    }
    
}
