package com.YardenAvihai.moviehub.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.YardenAvihai.moviehub.R;
import com.YardenAvihai.moviehub.Constants;
import com.YardenAvihai.moviehub.Movie;
import com.YardenAvihai.moviehub.SignupActivity;

public class MovieDetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras != null && extras.containsKey(Constants.MOVIE))
            {
                Movie movie = extras.getParcelable(Constants.MOVIE);
                if (movie != null)
                {
                    MovieDetailsFragment movieDetailsFragment = MovieDetailsFragment.getInstance(movie);
                    getSupportFragmentManager().beginTransaction().add(R.id.movie_details_container, movieDetailsFragment).commit();
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    public void messageButton_click(View view) {
        Toast.makeText(getApplicationContext(), "Button clicked!", Toast.LENGTH_SHORT).show();

    }
}
