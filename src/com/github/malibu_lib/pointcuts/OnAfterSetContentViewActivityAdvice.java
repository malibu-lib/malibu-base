
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnAfterSetContentViewActivityAdvice extends Advice {

    public void onAfterSetContentView(Activity activity);
}
