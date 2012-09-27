
package com.github.malibu_lib;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.res.Configuration;

import com.github.malibu_lib.internal.ApplicationPointcutManager;

public class AspectApplication extends Application implements Pointcut {

    // Pointcut definition

    private final ApplicationPointcutManager pointcutManager = new ApplicationPointcutManager(this);

    @Override
    public void registerAdvice(Advice advice) {
        pointcutManager.registerAdvice(advice);
    }

    // Aspect points

    @Override
    public void onCreate() {
        super.onCreate();
        pointcutManager.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        pointcutManager.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        pointcutManager.onLowMemory();
    }

    @Override
    @TargetApi(14)
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        pointcutManager.onTrimMemory(level);
    }

}
