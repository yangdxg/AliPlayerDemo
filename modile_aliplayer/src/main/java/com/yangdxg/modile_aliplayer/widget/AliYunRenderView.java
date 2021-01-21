package com.yangdxg.modile_aliplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.IPlayer;
import com.aliyun.player.source.UrlSource;
import com.aliyun.player.source.VidAuth;
import com.aliyun.player.source.VidMps;

/**
 * @Description: 播放器代理类
 * @Author: yangdxg
 * @CreateDate: 1/21/21 2:53 PM
 */
public class AliYunRenderView extends FrameLayout implements SurfaceHolder.Callback {

    private Context mContext;
    private AliPlayer mAliPlayer;
    private SurfaceView mIRenderView;
    private Surface mSurface;

    public AliYunRenderView(@NonNull Context context) {
        this(context, null);
    }

    public AliYunRenderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AliYunRenderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initPlayer();
    }

    private void initPlayer() {
        mAliPlayer = AliPlayerFactory.createAliPlayer(mContext.getApplicationContext());
        initPlayerListener();
        setSurface();
    }

    /**
     * 定义播放器的监听器，根据需要添加
     */
    private void initPlayerListener() {

    }

    /**
     * @return
     */
    public AliPlayer getAliPlayer() {
        return mAliPlayer;
    }

    /**
     * 设置SurfaceView，prepare前调用
     */
    private void setSurface() {
        mIRenderView = new SurfaceView(mContext);
        mIRenderView.getHolder().addCallback(this);
        addView(mIRenderView);
    }

    /**
     * 设置播放源
     *
     * @param vidAuth
     */
    public void setDataSource(VidAuth vidAuth) {
        if (mAliPlayer != null) {
            mAliPlayer.setDataSource(vidAuth);
        }
    }

    /**
     * 设置播放源
     *
     * @param vidMps
     */
    public void setDataSource(VidMps vidMps) {
        if (mAliPlayer != null) {
            mAliPlayer.setDataSource(vidMps);
        }
    }

    /**
     * 设置播放源
     */
    public void setDataSource(UrlSource urlSource) {
        if (mAliPlayer != null) {
            mAliPlayer.setDataSource(urlSource);
        }
    }

    /**
     * 是否开启自动播放
     */
    public void setAutoPlay(boolean isAutoPlay) {
        if (mAliPlayer != null) {
            mAliPlayer.setAutoPlay(isAutoPlay);
        }
    }

    public void release() {
        if (mAliPlayer != null) {
            stop();
            mAliPlayer.setSurface(null);
            mAliPlayer.release();
            mAliPlayer = null;
        }
        mSurface = null;
    }

    /**
     * 停止播放
     */
    public void stop() {
        if (mAliPlayer != null) {
            mAliPlayer.stop();
        }
    }

    /**
     * prepare
     */
    public void prepare() {
        if (mAliPlayer != null) {
            mAliPlayer.prepare();
        }
    }

    /**
     * 暂停播放,直播流不建议使用
     */
    public void pause() {
        if (mAliPlayer != null) {
            mAliPlayer.pause();
        }
    }

    public void start() {
        if (mAliPlayer != null) {
            mAliPlayer.start();
        }
    }

    public void reload() {
        if (mAliPlayer != null) {
            mAliPlayer.reload();
        }
    }

    /**
     * 获取视频时长
     */
    public long getDuration() {
        if (mAliPlayer != null) {
            return mAliPlayer.getDuration();
        }
        return 0;
    }

    /**
     * seek
     *
     * @param position 目标位置
     * @param seekMode 精准/非精准seek
     */
    public void seekTo(long position, IPlayer.SeekMode seekMode) {
        if (mAliPlayer != null) {
            mAliPlayer.seekTo(position, seekMode);
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if (mAliPlayer != null) {
            mSurface = holder.getSurface();
            mAliPlayer.setSurface(mSurface);
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        if (mAliPlayer != null) {
            mAliPlayer.surfaceChanged();
        }
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        if (mAliPlayer != null) {
            mAliPlayer.setSurface(null);
        }
    }
}
