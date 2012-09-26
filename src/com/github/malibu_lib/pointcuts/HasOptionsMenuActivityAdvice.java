
package com.github.malibu_lib.pointcuts;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface HasOptionsMenuActivityAdvice extends Advice {

    public boolean hasOptionsMenu(Activity activity);
}
