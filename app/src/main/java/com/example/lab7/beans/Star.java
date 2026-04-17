package com.example.lab7.beans;

/**
 * Classe Bean pour représenter une Star (Héros)
 */
public class Star {
    private int id_mouad;
    private String name_mouad;
    private String img_mouad;
    private float rating_mouad;
    private static int counter_mouad = 0;

    public Star(String name_mouad, String img_mouad, float rating_mouad) {
        this.id_mouad = ++counter_mouad;
        this.name_mouad = name_mouad;
        this.img_mouad = img_mouad;
        this.rating_mouad = rating_mouad;
    }

    public int getId() { return id_mouad; }
    public String getName() { return name_mouad; }
    public String getImg() { return img_mouad; }
    public float getRating() { return rating_mouad; }

    public void setName(String name_mouad) { this.name_mouad = name_mouad; }
    public void setImg(String img_mouad) { this.img_mouad = img_mouad; }
    public void setRating(float rating_mouad) { this.rating_mouad = rating_mouad; }
}
