package com.example.golu.songs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView y;
    String video_code="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        video_code = bundle.getString("videoId");

        y=(YouTubePlayerView)findViewById(R.id.youtubeView);

        y.initialize( "USE YOUR AIZA VALUE" ,this);



    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(video_code);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "somthing went wrong", Toast.LENGTH_SHORT).show();
    }
}

