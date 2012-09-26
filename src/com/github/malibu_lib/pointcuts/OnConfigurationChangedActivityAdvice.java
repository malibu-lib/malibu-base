
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.content.res.Configuration;

import com.github.malibu_lib.Advice;

public interface OnConfigurationChangedActivityAdvice extends Advice {

    void onConfigurationChanged(Activity activity, Configuration newConfig);
}
