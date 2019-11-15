package id.qoisabd.moviecataloguesub1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import id.qoisabd.moviecataloguesub1.adapter.MovieAdapter;
import id.qoisabd.moviecataloguesub1.model.Movie;

public class MainActivity extends AppCompatActivity {

    private TypedArray dataImage;

    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataDateRelease;

    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieAdapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(movieAdapter);

        addData();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                Movie movie = new Movie();
                movie.setImage(movies.get(i).getImage());
                movie.setTitle(movies.get(i).getTitle());
                movie.setDescription(movies.get(i).getDescription());
                movie.setDateRelease(movies.get(i).getDateRelease());
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("object", movie);
                startActivity(intent);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            Log.i("title", dataTitle[i]);

            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setDateRelease(dataDateRelease[i]);
            movie.setImage(dataImage.getResourceId(i, -1));
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    private void addData() {
        dataImage = getResources().obtainTypedArray(R.array.data_photo);
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataDateRelease = getResources().getStringArray(R.array.data_date_release);
    }

}

