
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnDestroyActivityAdvice extends Advice {

    public void onDestroy(Activity activity);
}
