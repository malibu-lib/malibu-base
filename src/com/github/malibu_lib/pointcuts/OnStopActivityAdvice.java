
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnStopActivityAdvice extends Advice {

    public void onStop(Activity activity);
}
