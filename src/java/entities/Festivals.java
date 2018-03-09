package entities;

/**
 *
 * @author sinem
 */
public class Festivals {

    private int id;
    private String name;
    private String country;
    private String imageUrl;
    private String description;
    private int year;

    public Festivals() {
    }

    public Festivals(int id, String name, String country, String imageUrl, String description, int year) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

}
