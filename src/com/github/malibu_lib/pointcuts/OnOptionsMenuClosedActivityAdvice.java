
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.view.Menu;

import com.github.malibu_lib.Advice;

public interface OnOptionsMenuClosedActivityAdvice extends Advice {

    public void onOptionsMenuClosed(Activity activity, Menu menu);
}
