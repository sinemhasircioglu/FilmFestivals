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
    private List<Juries> juryList;
    private List<Films> filmList;

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

    public List<Juries> getJuryList() {
        return juryList;
    }

    public void setJurylist(List<Juries> juryList) {
        this.juryList = juryList;
    }

    public List<Films> getFilmList() {
        return filmList;
    }

    public void setFilmlist(List<Films> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Festivals{" + "id=" + id + ", name=" + name + ", country=" + country + ", description=" + description + ", year=" + year + ", juryList=" + juryList + ", filmList=" + filmList + '}';
    }

}
