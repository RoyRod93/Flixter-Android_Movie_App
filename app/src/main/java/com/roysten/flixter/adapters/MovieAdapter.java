package com.roysten.flixter.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.roysten.flixter.DetailActivity;
import com.roysten.flixter.R;
import com.roysten.flixter.models.Movie;

import org.parceler.Parcels;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

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

        RelativeLayout moviesContainer;
        TextView tvMovieTitle, tvMovieOverview;
        ImageView ivMoviePoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);
            tvMovieOverview = itemView.findViewById(R.id.tvMovieOverView);
            ivMoviePoster = itemView.findViewById(R.id.ivMoviePoster);
            moviesContainer = itemView.findViewById(R.id.movie_container);
        }

        public void bind(final Movie movie) {
            tvMovieTitle.setText(movie.getMovieTitle());
            tvMovieOverview.setText(movie.getMovieOverview());

            String backdropImgUrl;
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                backdropImgUrl = movie.getMovieBackdropPath();
            } else {
                backdropImgUrl = movie.getPosterPath();
            }


            int radius = 25; // corner radius, higher value = more rounded
            int margin = 5; // crop margin, set to 0 for corners with no crop
            Glide.with(context)
                    .load(backdropImgUrl)
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.image_not_found)
                    .override(370, 580)
                    .transform(new RoundedCornersTransformation(radius, margin))
                    .into(ivMoviePoster);


            moviesContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("movieObj", Parcels.wrap(movie));
                    Pair<View, String> p1 = Pair.create((View) tvMovieTitle, "titleTransit");
                    Pair<View, String> p2 = Pair.create((View) tvMovieOverview, "overviewTransit");
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, p1, p2);
                    context.startActivity(intent, options.toBundle());


                }
            });

        }
    }
}
