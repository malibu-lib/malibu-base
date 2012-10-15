
package com.github.malibu_lib.pointcuts.activity;

import android.app.Activity;
import android.view.KeyEvent;

import com.github.malibu_lib.Advice;

public interface OnKeyDownActivityAdvice extends Advice {

    public boolean onKeyDown(Activity activity, int keyCode, KeyEvent event);

}
