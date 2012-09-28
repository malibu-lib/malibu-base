
package com.github.malibu_lib.internal;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

import com.github.malibu_lib.Pointcut;
import com.github.malibu_lib.pointcuts.service.OnBindServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnConfigurationChangedServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnCreateServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnDestroyServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnLowMemoryServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnRebindServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnStartCommandServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnTaskRemovedServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnTrimMemoryServiceAdvice;
import com.github.malibu_lib.pointcuts.service.OnUnbindServiceAdvice;

public class ServicePointcutManager extends PointcutManager<Service> implements Pointcut {

    public ServicePointcutManager(Service pointcut) {
        super(pointcut);
    }

    public IBinder onBind(Intent intent) {
        IBinder binder = null;
        OnBindServiceAdvice binderCreator = null;
        for (OnBindServiceAdvice advice : advices(OnBindServiceAdvice.class)) {
            IBinder adviceBinder = advice.onBind(pointcut, intent);
            if (adviceBinder != null) {
                if (binder != null) {
                    Log.e(TAG, "Multiple advices create binder for service");
                    Log.d(TAG, "service = " + pointcut.getClass().getName());
                    Log.d(TAG, "first binder =  " + binderCreator.getClass().getName());
                    Log.d(TAG, "second binder = " + advice.getClass().getName());
                    throw new IllegalStateException(
                            "Multiple advices create view for fragment. Check logcat for details");
                }
                binder = adviceBinder;
                binderCreator = advice;
            }
        }
        return binder;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for (OnConfigurationChangedServiceAdvice advice : advices(OnConfigurationChangedServiceAdvice.class)) {
            advice.onConfigurationChanged(pointcut, newConfig);
        }
    }

    public void onCreate() {
        for (OnCreateServiceAdvice advice : advices(OnCreateServiceAdvice.class)) {
            advice.onCreate(pointcut);
        }
    }

    public void onDestroy() {
        for (OnDestroyServiceAdvice advice : advices(OnDestroyServiceAdvice.class)) {
            advice.onDestroy(pointcut);
        }
    }

    public void onLowMemory() {
        for (OnLowMemoryServiceAdvice advice : advices(OnLowMemoryServiceAdvice.class)) {
            advice.onLowMemory(pointcut);
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int level) {
        for (OnTrimMemoryServiceAdvice advice : advices(OnTrimMemoryServiceAdvice.class)) {
            advice.onTrimMemory(pointcut, level);
        }
    }

    public void onRebind(Intent intent) {
        for (OnRebindServiceAdvice advice : advices(OnRebindServiceAdvice.class)) {
            advice.onRebind(pointcut, intent);
        }
    }

    public void onStartCommand(Intent intent, int flags, int startId) {
        for (OnStartCommandServiceAdvice advice : advices(OnStartCommandServiceAdvice.class)) {
            advice.onStartCommand(pointcut, intent, flags, startId);
        }
    }

    public void onTaskRemoved(Intent rootIntent) {
        for (OnTaskRemovedServiceAdvice advice : advices(OnTaskRemovedServiceAdvice.class)) {
            advice.onTaskRemoved(pointcut, rootIntent);
        }
    }

    public boolean onUnbind(Intent intent) {
        boolean result = false;
        for (OnUnbindServiceAdvice advice : advices(OnUnbindServiceAdvice.class)) {
            result |= advice.onUnbind(pointcut, intent);
        }
        return result;
    }

}
