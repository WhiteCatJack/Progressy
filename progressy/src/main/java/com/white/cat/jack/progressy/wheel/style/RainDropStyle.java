package com.white.cat.jack.progressy.wheel.style;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;

/**
 * Description.
 *
 * @author 泽乾
 * createAt 2018/12/11 7:49 PM
 */
public class RainDropStyle extends AbstractStyle{

    private int mColor = Color.BLACK;

    @Override
    public void draw(Canvas canvas, Path path, Paint paint, RectF rectF,
                     float sideLength, float timeRatio) {
        // prepare
        float halfSideLength = sideLength / 2;
        float oneThirdSideLength = sideLength / 3;
        float oneSixthSideLength = halfSideLength - oneThirdSideLength;

        path.reset();

        // set
        paint.setColor(mColor);

        // make a shape
        path.moveTo(halfSideLength, 0);
        rectF.set(0, 0, sideLength, sideLength);
        path.arcTo(rectF, 270, -180);
        rectF.set(oneSixthSideLength, oneThirdSideLength, sideLength - oneSixthSideLength, sideLength);
        path.arcTo(rectF, 90, 180);
        rectF.set(oneThirdSideLength, 0, sideLength - oneThirdSideLength, oneThirdSideLength);
        path.arcTo(rectF, 90, -180);

        canvas.save();
        canvas.rotate(timeRatio * 360, halfSideLength, halfSideLength);
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override
    public void setColor(@ColorInt int color) {
        this.mColor = color;
    }
}
