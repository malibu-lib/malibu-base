
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnRestartActivityAdvice extends Advice {

    void onRestart(Activity activity);
}
