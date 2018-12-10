package com.white.cat.jack.progressy.wheel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author 泽乾
 * createAt 2018/12/7 2:57 PM
 */
public class FlowerStyle extends AbstractProgressWheelStyle {

    private static final float DIMEN_DEFAULT_CLOCK_HAND_LENGTH_RATIO_TO_SIDE = 0.6f;
    private static final float DIMEN_DEFAULT_CLOCK_HAND_WIDTH_RATIO_TO_SIDE = 0.02f;
    private static final int NUMBER_LINE_COUNT = 12;
    private static final float DIMEN_STROKE_WIDTH = 6f;// 1dp外, 1dp内

    private static final String TAG = "FlowerStyle";

    /**
     * I am a perfect symmetry flower, and the width of mine must equals to the height of mine...
     * I will pick the smallest number in these two,
     * Then this value will be assigned to the width and height of mine...
     */
    @Override
    public void measure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);

        int temp = Math.min(width, height);
        mWidth = temp;
        mHeight = temp;
    }

    /*
                                 XX
                                 XX
                   XX            XX           XXX
                    XX           XX          XX
                     XXX         XX          X
                       XX        XX        XX
                        XX       XX       XX
          X              XXX     XX     XXX               X
           XXXXXX          XX    XX   XXX            XXXXX
                XXXXXXX     XXX  XX   X      XXXXXXXX
                      XXXXXXX  X XX XXX  XXXXX
                            XXXX XX  XXXX
        XXXXXXXXXXXXXXXXXXXXXXXX    XXXXXXXXXXXXXXXXXXXXXXXXX
                           XXXXX XX XXXX
                        XXXX   X XX XX XXXX
                  XXXXXXX     XX XX  XX    XXXX
               XXXXXX       XXX  XX   XX       XXX
            XXX            XX    XX    XX          XXX
          XXX             XX     XX      X           XXXX
                        XXX      XX      XX
                       XX        XX       XX
                      XX         XX        XX
                    XX           XX         XX
                   XX            XX           X
     */

    /**
     * Draw a background roughly like above, all lines are rectangle:
     * And then draw a clock hand moves clockwise to "cover" each of the line in the background
     * It's not simply drawing two times.
     * Actually is using the clock hand to replace each of the line successively
     *
     * @param canvas drawing tool
     * @param paint  drawing tool
     * @param path   drawing tool
     * @param rectF  drawing tool, usually is the assistant to draw a arc
     */
    @Override
    public void draw(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        int side = mView.getWidth();
        // side must be a non-negative value
        int halfSide = side >> 1;

        // get interpolator's value
        int lineCount = NUMBER_LINE_COUNT;
        int intervalDegree = 360 / lineCount;
        int whoGonnaBeClockHand = getClockHandIndex(intervalDegree);
        for (int i = 0; i < lineCount; i++) {
            boolean isHand = false;
            if (i == whoGonnaBeClockHand) {
                isHand = true;
            }
            drawTopLine(canvas, paint, rectF, isHand);
            canvas.rotate(intervalDegree, halfSide, halfSide);
        }
    }

    @IntRange(from = 0, to = NUMBER_LINE_COUNT - 1)
    private int getClockHandIndex(int interval) {
        int degreeFrom0To360 = super.getAnimatedValue();
        return degreeFrom0To360 / interval;
    }

    /**
     * draw a top clock hand in 12 o'clock when canvas is not rotated or moved
     *
     * @param canvas
     * @param paint
     * @param rectF
     * @param isHand to judge if this line is the clock hand
     */
    private void drawTopLine(Canvas canvas, Paint paint, RectF rectF, boolean isHand) {
        int side = mView.getWidth();
        // side must be a non-negative value
        int halfSide = side >> 1;

        int lineLength = (int) (halfSide * DIMEN_DEFAULT_CLOCK_HAND_LENGTH_RATIO_TO_SIDE + 0.5f);
        int lineWidth = (int) (side * DIMEN_DEFAULT_CLOCK_HAND_WIDTH_RATIO_TO_SIDE / 2 + 0.5f);
        int halfStrokeWidth = (int) (DIMEN_STROKE_WIDTH / 2 + 0.5f);

        rectF.set(halfSide - lineWidth, halfStrokeWidth, halfSide + lineWidth, lineLength - halfStrokeWidth);
        // draw stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(DIMEN_STROKE_WIDTH);
        paint.setColor(mStrokeColor);
        canvas.drawRect(rectF, paint);
        // fill it
        paint.setStyle(Paint.Style.FILL);
        if (isHand) {
            paint.setColor(mStrokeColor);
        } else {
            paint.setColor(mFillColor);
        }
        canvas.drawRect(rectF, paint);
    }
}
