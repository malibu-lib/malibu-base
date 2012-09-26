
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnStartActivityAdvice extends Advice {

    public void onStart(Activity activity);
}
