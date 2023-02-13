package com.antivariant.testapi;

public class FilmDataModel {

    private int id;
    private String title;
    private int year;
    private String actors;

    public FilmDataModel(int id, String title, int year, String actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.actors = actors;
    }

    public FilmDataModel() {

    }

    @Override
    public String toString() {
        return "FilmDataModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", actors='" + actors + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
