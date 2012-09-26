
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnPauseActivityAdvice extends Advice {

    public void onPause(Activity activity);
}
