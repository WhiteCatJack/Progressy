package com.white.cat.jack.progressy.wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.white.cat.jack.progressy.R;
import com.white.cat.jack.progressy.wheel.style.AbstractStyle;
import com.white.cat.jack.progressy.wheel.style.RainDropStyle;
import com.white.cat.jack.progressy.wheel.style.TieStyle;

/**
 * @author 泽乾
 * createAt 2018/12/7 2:43 PM
 */
public class ProgressWheel extends View {

    private int mSideLength;

    private AbstractStyle mStyle = new RainDropStyle();

    public ProgressWheel(Context context) {
        super(context);
        init();
    }

    public ProgressWheel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressWheel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mStyle.init(this);
        // for test
        setColor(ContextCompat.getColor(getContext(), R.color.nice_blue));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mStyle.startAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mStyle.resetAnimation();
    }

    /**
     * Make this view a square
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int sideLength = Math.min(width, height);
        this.mSideLength = sideLength;

        setMeasuredDimension(sideLength, sideLength);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mStyle.draw(canvas, mSideLength);
    }

    public void setStyle(@NonNull TieStyle style) {
        this.mStyle = style;
    }

    public void setColor(@ColorInt int color) {
        mStyle.setColor(color);
        invalidate();
    }
}