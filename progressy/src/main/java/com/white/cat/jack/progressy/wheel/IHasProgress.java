package com.white.cat.jack.progressy.wheel;

import android.support.annotation.FloatRange;

/**
 * 如果包含进度设置的ProgressWidget需要实现该接口
 *
 * @author 泽乾
 * createAt 2018/12/11 3:53 PM
 */
public interface IHasProgress {
    /**
     * 设置进度
     *
     * @param progress 进度
     */
    void setProgress(@FloatRange(from = 0, to = 100) float progress);
}
