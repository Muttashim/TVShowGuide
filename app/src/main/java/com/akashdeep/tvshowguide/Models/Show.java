package com.akashdeep.tvshowguide.Models;

import java.io.Serializable;

/**
 * Created by Akash on 17-03-2018.
 */

public class Show implements Serializable {
    String id;
    String title;
    String year;
    String userScore;
    String noOfEpisodes;
    String noOfSeasons;
    boolean production;
    String posterPath;
    String backdropPath;
    String genre;
    String overview;

    public Show(String id, String title, String year, String userScore, String noOfEpisodes, String noOfSeasons, boolean production, String posterPath, String backdropPath, String genre, String overview) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.userScore = userScore;
        this.noOfEpisodes = noOfEpisodes;
        this.noOfSeasons = noOfSeasons;
        this.production = production;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.genre = genre;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public String getTitleOnly(){return title;}

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return String.format("%s (%s)",title,year);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUserScore() {
        return (String.format("%s%%", userScore));
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getNoOfEpisodes() {
        return noOfEpisodes;
    }

    public void setNoOfEpisodes(String noOfEpisodes) {
        this.noOfEpisodes = noOfEpisodes;
    }

    public String getNoOfSeasons() {
        return noOfSeasons;
    }

    public void setNoOfSeasons(String noOfSeasons) {
        this.noOfSeasons = noOfSeasons;
    }

    public boolean isProduction() {
        return production;
    }

    public void setProduction(boolean production) {
        this.production = production;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w600_and_h900_bestv2%s",posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/original%s",backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
