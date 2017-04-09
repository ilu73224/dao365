package com.stc.dao365;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;

public class MainActivity extends Activity implements OnPreparedListener {

    private EMVideoView emVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupVideoView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(emVideoView != null && emVideoView.isPlaying())
            emVideoView.stopPlayback();
    }

    private void setupVideoView() {
        emVideoView = (EMVideoView)findViewById(R.id.video_view);
        emVideoView.setOnPreparedListener(this);

        //For now we just picked an arbitrary item to play.  More can be found at
        //https://archive.org/details/more_animation
        emVideoView.setVideoURI(Uri.parse("http://www.dao365.live/uploads/index.m3u8"));
    }

    @Override
    public void onPrepared() {
        emVideoView.start();
    }
}
