
package com.github.malibu_lib.pointcuts.application;

import android.annotation.TargetApi;
import android.app.Application;

import com.github.malibu_lib.Advice;

@TargetApi(14)
public interface OnTrimMemoryApplicationAdvice extends Advice {

    public void onTrimMemory(Application application, int level);

}
