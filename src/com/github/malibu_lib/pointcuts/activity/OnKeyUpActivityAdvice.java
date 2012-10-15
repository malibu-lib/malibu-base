
package com.github.malibu_lib.pointcuts.activity;

import android.app.Activity;
import android.view.KeyEvent;

import com.github.malibu_lib.Advice;

public interface OnKeyUpActivityAdvice extends Advice {

    boolean onKeyUp(Activity pointcut, int keyCode, KeyEvent event);

}
