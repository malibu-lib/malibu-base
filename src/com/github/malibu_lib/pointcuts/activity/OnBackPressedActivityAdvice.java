
package com.github.malibu_lib.pointcuts.activity;

import android.app.Activity;

import com.github.malibu_lib.Advice;

public interface OnBackPressedActivityAdvice extends Advice {

    public boolean onBackPressed(Activity activity);

}
