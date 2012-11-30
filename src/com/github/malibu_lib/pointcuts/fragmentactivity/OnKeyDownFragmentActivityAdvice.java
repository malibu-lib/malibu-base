
package com.github.malibu_lib.pointcuts.fragmentactivity;

import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.github.malibu_lib.Advice;

public interface OnKeyDownFragmentActivityAdvice extends Advice {

    public boolean onKeyDown(FragmentActivity activity, int keyCode, KeyEvent event);

}
