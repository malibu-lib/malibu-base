
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;

import com.github.malibu_lib.Advice;

public interface OnDestroyServiceAdvice extends Advice {

    public void onDestroy(Service service);

}
