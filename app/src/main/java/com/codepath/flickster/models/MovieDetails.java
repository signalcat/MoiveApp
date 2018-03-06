package com.codepath.flickster.models;

import java.io.Serializable;

/**
 * Created by hezhang on 9/15/17.
 */

public class MovieDetails implements Serializable {
    private String popularity;
    private String voteAverage;
    private String releaseDate;
    private String title;
    private String id;

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getId() {
        return id;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public void setVoteAverage(String voteAverage ) {
        this.voteAverage = voteAverage;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }
}
