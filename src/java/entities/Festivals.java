package entities;

import java.util.List;

/**
 *
 * @author sinem
 */
public class Festivals {

    private int id;
    private String name;
    private String country;
    private String description;
    private int year;
    private List<Juries> jurylist;
    private List<Films> filmlist;

    public Festivals() {
    }

    public Festivals(int id, String name, String country, String description, int year) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
        this.year = year;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        return "Festivals{" + "id=" + id + ", name=" + name + ", country=" + country + ", description=" + description + ", year=" + year + ", jurylist=" + jurylist + ", filmlist=" + filmlist + '}';
    }

}
