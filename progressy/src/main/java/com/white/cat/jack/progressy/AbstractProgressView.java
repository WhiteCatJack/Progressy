package com.white.cat.jack.progressy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description.
 *
 * @author 泽乾
 * createAt 2018/12/10 11:46 AM
 */
public abstract class AbstractProgressView extends View {

    private static final float NORMAL_ALPHA = 1f;
    private static final float DISABLE_ALPHA = 0.4f;

    protected Paint mPaint;
    protected Path mPath;
    protected RectF mRectF;

    private void initTools() {
        mPaint = new Paint();
        mPath = new Path();
        mRectF = new RectF();
    }

    public AbstractProgressView(Context context) {
        super(context);
        initTools();
    }

    public AbstractProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTools();
    }

    public AbstractProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTools();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            this.setAlpha(DISABLE_ALPHA);
        } else {
            this.setAlpha(NORMAL_ALPHA);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
