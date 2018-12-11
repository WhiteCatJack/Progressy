package com.white.cat.jack.progressy.wheel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.white.cat.jack.progressy.R;
import com.white.cat.jack.progressy.wheel.style.AbstractStyle;
import com.white.cat.jack.progressy.wheel.style.RainDropStyle;
import com.white.cat.jack.progressy.wheel.style.TieStyle;

/**
 * @author 泽乾
 * createAt 2018/12/7 2:43 PM
 */
public class ProgressWheel extends View {

    protected Paint mPaint;
    protected Path mPath;
    protected RectF mRectF;

    private int mSideLength;

    private static final int DURATION_IN_MILLIS = 2000;
    private ValueAnimator mAnimator;
    private float mDegree;

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
        initTools();
        initAnimator();
        // for test
        setColor(ContextCompat.getColor(getContext(), R.color.nice_blue));
    }

    private void initTools() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        mPaint = paint;

        mPath = new Path();
        mRectF = new RectF();
    }

    private void initAnimator() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 359.999999f);
        animator.setDuration(DURATION_IN_MILLIS);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDegree = (float) animation.getAnimatedValue();
                invalidate();
            }
        });

        mAnimator = animator;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAnimator.cancel();
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

        mStyle.draw(canvas, mPath, mPaint, mRectF, mSideLength, mDegree);
    }

    public void setStyle(@NonNull TieStyle style) {
        this.mStyle = style;
    }

    public void setColor(@ColorInt int color) {
        mStyle.setColor(color);
        invalidate();
    }
}