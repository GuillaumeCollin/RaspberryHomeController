package com.homeController.serialisation;

import java.util.List;

public class DeleteMovieBody {

    private String id;


    public DeleteMovieBody() {
    }

    public DeleteMovieBody(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
