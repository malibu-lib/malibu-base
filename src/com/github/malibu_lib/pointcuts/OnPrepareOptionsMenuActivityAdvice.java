
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.view.Menu;

import com.github.malibu_lib.Advice;

public interface OnPrepareOptionsMenuActivityAdvice extends Advice {

    public boolean onPrepareOptionsMenu(Activity activity, Menu menu);
}
