package com.white.cat.jack.progressy.wheel.style;

import android.graphics.Canvas;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorInt;
import android.view.View;

/**
 * @author 泽乾
 * createAt 2018/12/11 8:46 PM
 */
public abstract class AbstractStyle {

    private View mView;

    @CallSuper
    public void init(View view) {
        this.mView = view;
    }

    public abstract void setColor(@ColorInt int color);

    public abstract void startAnimation();

    public abstract void resetAnimation();

    public abstract void draw(Canvas canvas, float sideLength);

    protected void doneDraw() {
        mView.invalidate();
    }
}
