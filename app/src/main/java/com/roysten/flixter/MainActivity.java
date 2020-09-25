package com.roysten.flixter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.roysten.flixter.adapters.MovieAdapter;
import com.roysten.flixter.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "MainActivity";

    List<Movie> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_app_bar_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        RecyclerView rvMovies = findViewById(R.id.rvMovies);
        moviesList = new ArrayList<>();

        //create adapter
        final MovieAdapter movieAdapter = new MovieAdapter(this, moviesList);

        //set adapter to recyclerView
        rvMovies.setAdapter(movieAdapter);

        //set a Layout Manager on the recycler view
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        //AsyncHttpClient Network call to fetch movie data
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                //Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    //Log.i(TAG, "JSON Movie Now Playing Results: " + results.toString());
                    //Log.i(TAG, "Movies Count: " + moviesList.size());
                    moviesList.addAll(Movie.fromJsonArray(results));
                    movieAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    //Log.e(TAG, "JSON Exception Occurred!", e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                //Log.d(TAG, "onFailure");
            }
        });
    }
}
