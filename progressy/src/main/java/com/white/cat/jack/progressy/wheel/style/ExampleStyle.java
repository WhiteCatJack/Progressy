package com.white.cat.jack.progressy.wheel.style;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @author 泽乾
 * createAt 2018/12/13 10:01 AM
 */
public final class ExampleStyle extends AbstractStyle {

    private int mColor = Color.BLACK;

    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;

    private static final int DURATION_IN_MILLIS = 2000;
    private ValueAnimator mAnimator;

    @Override
    public void init(View view) {
        super.init(view);

        initTools();
        initAnimator();
    }

    private void initTools() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        mPaint = paint;

        mPath = new Path();
        mRectF = new RectF();
    }

    private void initAnimator() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 0.999999f);
        animator.setDuration(DURATION_IN_MILLIS);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                doneDraw();
            }
        });

        mAnimator = animator;
    }

    @Override
    public void setColor(int color) {
        this.mColor = color;
    }

    @Override
    public void startAnimation() {
        mAnimator.start();
    }

    @Override
    public void resetAnimation() {
        mAnimator.cancel();
    }

    @Override
    public void draw(Canvas canvas, float sideLength) {

    }
}
