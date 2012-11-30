
package com.github.malibu_lib.pointcuts.fragmentactivity;

import android.support.v4.app.FragmentActivity;

import com.github.malibu_lib.Advice;

public interface OnBackPressedFragmentActivityAdvice extends Advice {

    public boolean onBackPressed(FragmentActivity activity);

}
