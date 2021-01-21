package com.yangdxg.modile_aliplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.aliyun.player.source.UrlSource;

/**
 * 包含播放器{@link AliYunRenderView}
 *
 * @Description: 自定义阿里云播放器
 * @Author: yangdxg
 * @CreateDate: 1/21/21 3:13 PM
 */
public class AliYunVodPlayerView extends RelativeLayout {

    private AliYunRenderView mAliYunRenderView;

    public AliYunVodPlayerView(Context context) {
        this(context, null);
    }

    public AliYunVodPlayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AliYunVodPlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVideoView();
    }

    private void initVideoView() {
        // 初始化播放器
        initAliPlayer();
    }

    /**
     * 设置播放源
     *
     * @param urlSource 本地播放源
     */
    public void setLocalSource(UrlSource urlSource) {
        if (mAliYunRenderView == null) return;
        prepareLocalSource(urlSource);
    }

    private void prepareLocalSource(UrlSource urlSource) {
        mAliYunRenderView.setAutoPlay(true);
        mAliYunRenderView.setDataSource(urlSource);
        mAliYunRenderView.prepare();
    }

    /**
     * 初始化播放器
     */
    private void initAliPlayer() {
        mAliYunRenderView = new AliYunRenderView(getContext());
        addSubView(mAliYunRenderView);
    }

    /**
     * 添加子View到布局中
     *
     * @param view
     */
    private void addSubView(View view) {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(view, params);
    }
}
