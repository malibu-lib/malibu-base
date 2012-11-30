
package com.github.malibu_lib.pointcuts.fragmentactivity;

import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.github.malibu_lib.Advice;

public interface OnKeyUpFragmentActivityAdvice extends Advice {

    boolean onKeyUp(FragmentActivity pointcut, int keyCode, KeyEvent event);

}
