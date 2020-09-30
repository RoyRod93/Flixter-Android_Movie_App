package com.roysten.flixter;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.roysten.flixter.models.Movie;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle, tvOverview;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvDetailsTitle);
        tvOverview = findViewById(R.id.tvDetailsOverView);
        ratingBar = findViewById(R.id.ratingBar);

        Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movieObj"));
        tvTitle.setText(movie.getMovieTitle());
        tvOverview.setText(movie.getMovieOverview());
        ratingBar.setRating((float) movie.getRating());


    }
}