package com.white.cat.jack.progressy.wheel.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;

/**
 * @author 泽乾
 * createAt 2018/12/11 8:46 PM
 */
public abstract class AbstractStyle {

    public abstract void draw(Canvas canvas, Path path, Paint paint, RectF rectF,
                              float sideLength, float degree);

    public abstract void setColor(@ColorInt int color);
}
