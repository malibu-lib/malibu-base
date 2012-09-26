
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;

import com.github.malibu_lib.Advice;

public interface OnCreateOptionsMenuActivityAdvice extends Advice {

    public boolean onCreateOptionsMenu(Activity activity, Menu menu, MenuInflater menuInflater);
}
