package com.white.cat.jack.progressy.bar;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.white.cat.jack.progressy.AbstractProgressView;


/**
 * @author 泽乾
 * createAt 2018/12/7 2:43 PM
 */
public class ProgressBar extends AbstractProgressView implements ProgressBarFunctionInterface {


    public ProgressBar(Context context) {
        super(context);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private AbstractProgressBarStyle mStyle;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mStyle.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mStyle.getWidth(), mStyle.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mStyle.draw(canvas, mPaint, mPath, mRectF);
    }

    @Override
    public void setStyle(@NonNull AbstractProgressBarStyle style) {
        style.setView(this);
        this.mStyle = style;
    }

    @Override
    public void setStrokeColor(int color) {

    }

    @Override
    public void setFillColor(int color) {

    }
}
