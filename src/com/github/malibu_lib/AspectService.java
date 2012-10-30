
package com.github.malibu_lib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

import com.github.malibu_lib.internal.ServicePointcutManager;

@SuppressLint("Registered")
public class AspectService extends Service implements Pointcut {

    final ServicePointcutManager pointcutManager = new ServicePointcutManager(this);

    @Override
    public void registerAdvice(Advice advice) {
        pointcutManager.registerAdvice(advice);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return pointcutManager.onBind(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        pointcutManager.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        pointcutManager.onCreate();
    }

    @Override
    public void onDestroy() {
        pointcutManager.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        pointcutManager.onLowMemory();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        pointcutManager.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        pointcutManager.onStartCommand(intent, flags, startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    @TargetApi(14)
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        pointcutManager.onTaskRemoved(rootIntent);
    }

    @Override
    @TargetApi(14)
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        pointcutManager.onTrimMemory(level);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return pointcutManager.onUnbind(intent) || super.onUnbind(intent);
    }

}
