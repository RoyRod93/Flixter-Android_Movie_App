package com.roysten.flixter.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.roysten.flixter.R;
import com.roysten.flixter.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.movie_item_layout, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMovieTitle, tvMovieOverview;
        ImageView ivMoviePoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);
            tvMovieOverview = itemView.findViewById(R.id.tvMovieOverView);
            ivMoviePoster = itemView.findViewById(R.id.ivMoviePoster);
        }

        public void bind(Movie movie) {
            tvMovieTitle.setText(movie.getMovieTitle());
            tvMovieOverview.setText(movie.getMovieOverview());

            String backdropImgUrl;
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                backdropImgUrl = movie.getMovieBackdropPath();
            } else {
                backdropImgUrl = movie.getPosterPath();
            }

            Glide.with(context).load(backdropImgUrl).into(ivMoviePoster);
        }
    }
}
