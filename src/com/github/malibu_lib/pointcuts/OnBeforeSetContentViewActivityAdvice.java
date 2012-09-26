
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnBeforeSetContentViewActivityAdvice extends Advice {

    public void onBeforeSetContentView(Activity activity);

}
