package com.example.SD2.edu.gemini.app.ocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("ALL")
@Entity
public class ImageStar {
    @Id
    private int id;
    private String imageLink;

    public ImageStar() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
