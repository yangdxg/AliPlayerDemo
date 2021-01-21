package com.yangdxg.aliplayerdemo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aliyun.player.source.UrlSource;
import com.yangdxg.modile_aliplayer.widget.AliYunVodPlayerView;

/**
 * @Description:
 * @Author: yangdxg
 * @CreateDate: 1/21/21 3:23 PM
 */
public class AliCustomPlayerActivity extends AppCompatActivity {

    private AliYunVodPlayerView mAliCustomPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alicustom_player);
        mAliCustomPlayer = findViewById(R.id.ali_player_custom);
        UrlSource urlSource = new UrlSource();
        urlSource.setUri("https://vd3.bdstatic.com/mda-jg5q3222vqwpbfes/hd/mda-jg5q3222vqwpbfes.mp4");
        mAliCustomPlayer.setLocalSource(urlSource);
    }
}
