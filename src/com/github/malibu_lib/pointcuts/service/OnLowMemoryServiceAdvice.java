
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;

import com.github.malibu_lib.Advice;

public interface OnLowMemoryServiceAdvice extends Advice {

    public void onLowMemory(Service service);

}
