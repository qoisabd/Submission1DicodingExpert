package id.qoisabd.moviecataloguesub1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.qoisabd.moviecataloguesub1.R;
import id.qoisabd.moviecataloguesub1.model.Movie;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private ImageView imageView;
        private TextView textTitle;
        private TextView textDescription;
        private TextView textDateRelease;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.item_image);
            textTitle = view.findViewById(R.id.item_title);
            textDescription = view.findViewById(R.id.item_description);
            textDateRelease = view.findViewById(R.id.item_date_release);
        }

        void bind(Movie movie) {
            imageView.setImageResource(movie.getImage());
            textTitle.setText(movie.getTitle());
            textDescription.setText(movie.getDescription());
            textDateRelease.setText(movie.getDateRelease());
        }
    }
}