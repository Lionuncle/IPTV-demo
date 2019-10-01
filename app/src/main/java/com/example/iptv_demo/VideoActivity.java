package com.example.iptv_demo;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    String pathVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try{
            this.pathVideo = getIntent().getStringExtra("key");


            videoView = findViewById(R.id.videoView);

            final ProgressDialog progressDialog = new ProgressDialog(VideoActivity.this);
            progressDialog.setMessage("Connecting to the server...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);

            videoView.setVideoURI(Uri.parse(pathVideo));
            videoView.start();

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressDialog.setMessage("help me please...");
                    progressDialog.setMessage("Congiguring detalis...");
                    progressDialog.setMessage("Let me think...");
                    progressDialog.setMessage("Loading...");
                    progressDialog.setMessage("Done!");
                    progressDialog.dismiss();
                }
            });

        }
        catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }



    }

}
