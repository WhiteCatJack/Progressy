package com.white.cat.jack.progressy.wheel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.white.cat.jack.progressy.AbstractProgressView;

/**
 * @author 泽乾
 * createAt 2018/12/7 2:43 PM
 */
public class ProgressWheel extends AbstractProgressView implements ProgressWheelFunctionInterface {

    public ProgressWheel(Context context) {
        super(context);
    }

    public ProgressWheel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressWheel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private AbstractProgressWheelStyle mStyle;

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
    public void setShape(@NonNull AbstractProgressWheelStyle style) {
        style.setView(this);
        this.mStyle = style;
        mStyle.setAnimationUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        mStyle.startAnimation();
    }

    @Override
    public void setStrokeColor(int color) {
        mStyle.setStrokeColor(color);
    }

    @Override
    public void setFillColor(int color) {
        mStyle.setFillColor(color);
    }
}
