package com.yangdxg.modile_aliplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * @Description:
 * @Author: yangdxg
 * @CreateDate: 1/21/21 3:00 PM
 */
public class SurfaceRenderView extends SurfaceView implements IRenderView, SurfaceHolder.Callback {

    private IRenderCallback mRenderCallback;

    public SurfaceRenderView(Context context) {
        this(context, null);
    }

    public SurfaceRenderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceRenderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getHolder().addCallback(this);
    }

    @Override
    public void addRenderCallback(IRenderCallback renderCallback) {
        mRenderCallback = renderCallback;
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if (mRenderCallback != null) {
            mRenderCallback.onSurfaceCreate(holder.getSurface());
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        if (mRenderCallback != null) {
            mRenderCallback.onSurfaceChanged(width, height);
        }
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Surface surface = holder.getSurface();
        if (surface != null) surface.release();
        if (mRenderCallback != null) {
            mRenderCallback.onSurfaceDestroyed();
        }
    }
}
