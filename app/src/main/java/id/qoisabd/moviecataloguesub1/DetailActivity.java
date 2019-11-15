package id.qoisabd.moviecataloguesub1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import id.qoisabd.moviecataloguesub1.model.Movie;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textTitle, textDescription, textDateRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.detail_image);
        textTitle = findViewById(R.id.detail_title);
        textDescription = findViewById(R.id.detail_description);
        textDateRelease = findViewById(R.id.detail_date_release);

        Bundle bundle = getIntent().getExtras();
        Log.i("bundle", "true");

        if (bundle != null) {
            Log.i("bundle", "true");

            Movie movie = bundle.getParcelable("object");

            if (movie != null) {
                Log.i("bundle", "true");
                Log.i("info movie", movie.getTitle());
                Log.i("info movie", movie.getDescription());
                Log.i("info movie", movie.getDateRelease());

                imageView.setImageResource(movie.getImage());
                textTitle.setText(movie.getTitle());
                textDescription.setText(movie.getDescription());
                textDateRelease.setText(movie.getDateRelease());
            }
        }
    }
}
