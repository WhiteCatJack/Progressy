package com.white.cat.jack.progressy.wheel.style;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.white.cat.jack.progressy.wheel.Utils;

/**
 * Description.
 *
 * @author 泽乾
 * createAt 2018/12/11 7:49 PM
 */
public final class TieStyle extends AbstractStyle {


    private int mColor = Color.BLACK;

    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;

    private static final int DURATION_IN_MILLIS = 2000;
    private ValueAnimator mAnimator;

    private float mTimeRatio;

    private static final float LINE_THICKNESS_RATIO = 0.25f;

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
                mTimeRatio = (float) animation.getAnimatedValue();
                doneDraw();
            }
        });

        mAnimator = animator;
    }

    @Override
    public void setColor(@ColorInt int color) {
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
        Path path = mPath;
        Paint paint = mPaint;
        RectF rectF = mRectF;
        float timeRatio = mTimeRatio;

        // prepare
        float halfSideLength = sideLength / 2;
        int lineThickness = Utils.roundingUp(sideLength * LINE_THICKNESS_RATIO);

        path.rewind();

        // set
        paint.setColor(mColor);
        paint.setStyle(Paint.Style.FILL);

        // make a shape
        path.moveTo(halfSideLength, 0);
        rectF.set(0, 0, sideLength, sideLength);
        path.arcTo(rectF, 270, -180);
        path.rMoveTo(0, -lineThickness);
        rectF.set(lineThickness, lineThickness, sideLength - lineThickness, sideLength - lineThickness);
        path.arcTo(rectF, 90, 180);
        path.rMoveTo(0, -lineThickness);

        canvas.save();
        canvas.rotate(timeRatio * 360, halfSideLength, halfSideLength);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
