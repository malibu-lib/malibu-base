
package com.github.malibu_lib.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.res.Configuration;

import com.github.malibu_lib.pointcuts.application.OnConfigurationChangedApplicationAdvice;
import com.github.malibu_lib.pointcuts.application.OnCreateApplicationAdvice;
import com.github.malibu_lib.pointcuts.application.OnLowMemoryApplicationAdvice;
import com.github.malibu_lib.pointcuts.application.OnTrimMemoryApplicationAdvice;

public class ApplicationPointcutManager extends PointcutManager<Application> {

    public ApplicationPointcutManager(Application pointcut) {
        super(pointcut);
    }

    public void onCreate() {
        for (OnCreateApplicationAdvice advice : advices(OnCreateApplicationAdvice.class)) {
            advice.onCreate(pointcut);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for (OnConfigurationChangedApplicationAdvice advice : advices(OnConfigurationChangedApplicationAdvice.class)) {
            advice.onConfigurationChanged(pointcut, newConfig);
        }
    }

    public void onLowMemory() {
        for (OnLowMemoryApplicationAdvice advice : advices(OnLowMemoryApplicationAdvice.class)) {
            advice.onLowMemory(pointcut);
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int level) {
        for (OnTrimMemoryApplicationAdvice advice : advices(OnTrimMemoryApplicationAdvice.class)) {
            advice.onTrimMemory(pointcut, level);
        }
    }

}
