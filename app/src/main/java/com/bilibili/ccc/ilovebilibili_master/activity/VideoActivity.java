package com.bilibili.ccc.ilovebilibili_master.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bilibili.ccc.ilovebilibili_master.R;


public class VideoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player_view);

//        IjkMediaPlayer.loadLibrariesOnce(null);
//        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

//        mVideoView = (IjkVideoView) findViewById(R.id.video_player);
//        mVideoView.setVideoURI(Uri.parse(Config.URL + "video.mp4"));
//
//        mVideoView.start();

    }
}
