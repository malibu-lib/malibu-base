
package com.github.malibu_lib.pointcuts.application;

import android.app.Application;
import android.content.res.Configuration;

import com.github.malibu_lib.Advice;

public interface OnConfigurationChangedApplicationAdvice extends Advice {

    public void onConfigurationChanged(Application application, Configuration newConfig);

}
