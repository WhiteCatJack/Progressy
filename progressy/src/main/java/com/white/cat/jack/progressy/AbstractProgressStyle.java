package com.white.cat.jack.progressy;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Description.
 *
 * @author 泽乾
 * createAt 2018/12/7 3:56 PM
 */
public abstract class AbstractProgressStyle implements ProgressStyleInterface {

    protected View mView;
    protected int mWidth;
    protected int mHeight;

    @Override
    public void setView(@NonNull View view) {
        this.mView = view;
    }

    @Override
    public int getWidth() {
        return mWidth;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }
}
