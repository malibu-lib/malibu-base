
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.view.MenuItem;

import com.github.malibu_lib.Advice;

public interface OnOptionsItemSelectedActivityAdvice extends Advice {

    public boolean onOptionsItemSelected(Activity activity, MenuItem item);
}
