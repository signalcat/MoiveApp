package com.codepath.flickster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codepath.flickster.models.MovieDetails;
import com.codepath.flickster.models.Video;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MovieDetailsActivity extends AppCompatActivity {

    ArrayList<Video> videos;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // Get bundled movie details data
        MovieDetails movie_details = (MovieDetails) getIntent().getSerializableExtra("movie_details");
        // Hook data with ui elements
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        TextView tv_popularity = (TextView) findViewById(R.id.tv_popularity);
        TextView tv_voteAverage = (TextView) findViewById(R.id.tv_vote_average);
        TextView tv_releaseDate = (TextView) findViewById(R.id.tv_release_date);

        tv_title.setText(movie_details.getTitle());
        tv_popularity.setText(movie_details.getPopularity());
        tv_voteAverage.setText(movie_details.getVoteAverage());
        tv_releaseDate.setText(movie_details.getReleaseDate());

        // Build request based on movie id clicked
        String url = "https://api.themoviedb.org/3/movie/" + movie_details.getId() + "/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US";

        // Create a new arraylist to store the JsonObjects
        videos = new ArrayList<>();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray videoJsonResults = null;
                try {
                    videoJsonResults = response.getJSONArray("results");
                    videos.addAll(Video.fromJSONArray(videoJsonResults));
                    key = videos.get(0).getKey();

                    // Initialize youtube video
                    YouTubePlayerFragment youTubeFragment = (YouTubePlayerFragment)
                            getFragmentManager().findFragmentById(R.id.youtubeFragment);
                    youTubeFragment.initialize("AIzaSyBsYzO9bKX8UzJRf8CqU-rLQiu_uKb8I6A",
                            new YouTubePlayer.OnInitializedListener() {
                                @Override
                                public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                                    YouTubePlayer youTubePlayer, boolean b) {
                                    youTubePlayer.cueVideo(key);
                                }

                                @Override
                                public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                                    YouTubeInitializationResult youTubeInitializationResult) {

                                }
                            });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });


    }
}
