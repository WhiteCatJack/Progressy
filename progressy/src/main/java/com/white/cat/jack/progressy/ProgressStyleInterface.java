package com.white.cat.jack.progressy;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * All methods have to be invoked in right time
 *
 * @author 泽乾
 * createAt 2018/12/7 2:54 PM
 */
public interface ProgressStyleInterface {

    void setView(@NonNull View view);

    /**
     * Invoke this method in DtProgressWheel.OnMeasure to measure width and height
     * by individual style's strategy
     *
     * @param widthMeasureSpec  from DtProgressWheel.OnMeasure
     * @param heightMeasureSpec from DtProgressWheel.OnMeasure
     * @return An array of Integer, first element is measured width, second is measured height
     */
    void measure(int widthMeasureSpec, int heightMeasureSpec);

    /**
     * Invoke this after {@link #measure}
     *
     * @return measured width
     */
    int getWidth();

    /**
     * Invoke this after {@link #measure}
     *
     * @return measured height
     */
    int getHeight();

    /**
     * Invoke this method in DtProgressWheel.draw to draw
     * by individual style's strategy
     * This will always draw by path, use straight line or arc
     *
     * @param canvas drawing tool
     * @param paint  drawing tool
     * @param path   drawing tool
     * @param rectF  drawing tool, usually is the assistant to draw a arc
     */
    void draw(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF);

    void setStrokeColor(@ColorInt int color);

    void setFillColor(@ColorInt int color);
}
