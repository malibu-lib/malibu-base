
package com.github.malibu_lib.pointcuts.application;

import android.app.Application;

import com.github.malibu_lib.Advice;

public interface OnLowMemoryApplicationAdvice extends Advice {

    public void onLowMemory(Application application);

}
