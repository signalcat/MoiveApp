package com.codepath.flickster.models;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.codepath.flickster.R;

/**
 * Created by hezhang on 9/14/17.
 */


public class DialogDemoActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        showMovieDetailDialog();
    }

    private void showMovieDetailDialog() {
        FragmentManager fm = getSupportFragmentManager();
        MovieDetailsDialogFragment detailFragment = MovieDetailsDialogFragment.newInstance("Some title");
        detailFragment.show(fm, "fragment_moviedetails");
    }
}