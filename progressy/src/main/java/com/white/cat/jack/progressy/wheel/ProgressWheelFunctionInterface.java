package com.white.cat.jack.progressy.wheel;

import android.support.annotation.NonNull;

import com.white.cat.jack.progressy.ProgressFunctionInterface;

/**
 * @author 泽乾
 * createAt 2018/12/7 3:07 PM
 */
public interface ProgressWheelFunctionInterface extends ProgressFunctionInterface {
    void setShape(@NonNull AbstractProgressWheelStyle style);
}
