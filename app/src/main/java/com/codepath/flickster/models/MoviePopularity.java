package com.codepath.flickster.models;

/**
 * Created by hezhang on 9/16/17.
 */

public class MoviePopularity {
    public enum Popularity {
        POPULAR, LESSPOPULAR
    }

    public MoviePopularity(String label, Popularity popularity) {
        super();
        this.label = label;
        this.popularity = popularity;
    }

    public String label;
    public Popularity popularity;
}
