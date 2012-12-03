
package com.github.malibu_lib.pointcuts.activity;

import android.app.Activity;
import android.view.MenuItem;

import com.github.malibu_lib.Advice;

public interface OnContextItemSelectedActivityAdvice extends Advice {

    public boolean onContextItemSelected(Activity activity, MenuItem item);

}
