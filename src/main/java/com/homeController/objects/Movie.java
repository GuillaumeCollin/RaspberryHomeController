package com.homeController.objects;

import org.bson.BsonValue;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private String id;
    private String name;
    private long size;
    private String lang;
    private int stars;
    private String contentType;

    public Movie(String id, String name, long size) {
        this.name = name;
        this.size = size;
        this.id = id;
    }

    public Movie(String id, String name, long size, String contentType) {
        this(id, name, size);
        this.contentType = contentType;
    }

    public Movie(String id,String name, long size, String contentType, int stars, String lang){
        this(id, name, size, contentType);
        this.stars = stars;
        this.lang = lang;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getId() {
        return id;
    }
}
