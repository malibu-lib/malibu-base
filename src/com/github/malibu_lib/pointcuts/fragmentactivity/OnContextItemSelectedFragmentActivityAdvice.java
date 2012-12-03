
package com.github.malibu_lib.pointcuts.fragmentactivity;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

import com.github.malibu_lib.Advice;

public interface OnContextItemSelectedFragmentActivityAdvice extends Advice {

    public boolean onContextItemSelected(FragmentActivity activity, MenuItem item);

}
