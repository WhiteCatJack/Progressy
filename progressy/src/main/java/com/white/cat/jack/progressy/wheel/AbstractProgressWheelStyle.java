package com.white.cat.jack.progressy.wheel;

import android.animation.ValueAnimator;
import android.support.annotation.IntRange;
import android.view.animation.LinearInterpolator;

import com.white.cat.jack.progressy.AbstractProgressStyle;

/**
 * Description.
 *
 * @author 泽乾
 * createAt 2018/12/10 11:49 AM
 */
public abstract class AbstractProgressWheelStyle extends AbstractProgressStyle {

    protected static final int NUMBER_INTERVAL = 360;
    private static final int DURATION_IN_MILLIS = 1000;

    protected int mStrokeColor = 0xFF191F25;
    protected int mFillColor = 0xFFFFFFFF;

    private ValueAnimator mAnimator;

    public AbstractProgressWheelStyle() {
        initAnimation();
    }

    private void initAnimation() {
        mAnimator = ValueAnimator.ofInt(1, NUMBER_INTERVAL);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setDuration(DURATION_IN_MILLIS);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
    }

    @IntRange(from = 0, to = NUMBER_INTERVAL - 1)
    protected int getAnimatedValue() {
        return (int) mAnimator.getAnimatedValue();
    }

    public void setAnimationUpdateListener(ValueAnimator.AnimatorUpdateListener listener) {
        mAnimator.addUpdateListener(listener);
    }

    public void startAnimation() {
        mAnimator.start();
    }

    public void endAnimation() {
        mAnimator.end();
    }

    @Override
    public void setStrokeColor(int color) {
        this.mStrokeColor = color;
    }

    @Override
    public void setFillColor(int color) {
        this.mFillColor = color;
    }
}
