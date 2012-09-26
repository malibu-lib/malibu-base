
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnResumeActivityAdvice extends Advice {

    public void onResume(Activity activity);
}
