package com.roysten.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

//Plain Old Java Object (POJO)
@Parcel
public class Movie {
    private String posterPath;
    private String movieTitle;
    private String movieOverview;
    private String movieBackdropPath;
    private double rating;

    // empty constructor needed by the Parceler library
    public Movie() {

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        movieTitle = jsonObject.getString("title");
        movieOverview = jsonObject.getString("overview");
        movieBackdropPath = jsonObject.getString("backdrop_path");
        rating = jsonObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> moviesList = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            moviesList.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return moviesList;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getMovieBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", movieBackdropPath);
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public double getRating() {
        return rating;
    }


}
