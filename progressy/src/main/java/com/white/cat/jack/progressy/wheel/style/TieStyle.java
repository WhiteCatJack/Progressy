package com.white.cat.jack.progressy.wheel.style;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;

import com.white.cat.jack.progressy.wheel.Utils;

/**
 * Description.
 *
 * @author 泽乾
 * createAt 2018/12/11 7:49 PM
 */
public class TieStyle extends AbstractStyle {

    private int mColor = Color.BLACK;
    private static final float LINE_THICKNESS_RATIO = 0.25f;

    @Override
    public void draw(Canvas canvas, Path path, Paint paint, RectF rectF,
                     float sideLength, float degree) {
        // prepare
        float halfSideLength = sideLength / 2;
        int lineThickness = Utils.roundingUp(sideLength * LINE_THICKNESS_RATIO);

        path.reset();

        // set
        paint.setColor(mColor);

        // make a shape
        path.moveTo(halfSideLength, 0);
        rectF.set(0, 0, sideLength, sideLength);
        path.arcTo(rectF, 270, -180);
        path.rMoveTo(0, -lineThickness);
        rectF.set(lineThickness, lineThickness, sideLength - lineThickness, sideLength - lineThickness);
        path.arcTo(rectF, 90, 180);
        path.rMoveTo(0, -lineThickness);

        canvas.save();
        canvas.rotate(degree, halfSideLength, halfSideLength);
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override
    public void setColor(@ColorInt int color) {
        this.mColor = color;
    }
}
