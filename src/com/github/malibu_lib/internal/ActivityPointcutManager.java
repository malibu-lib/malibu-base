
package com.github.malibu_lib.internal;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.malibu_lib.AspectActivity;
import com.github.malibu_lib.pointcuts.OnActivityResultActivityAdvice;
import com.github.malibu_lib.pointcuts.OnAfterSetContentViewActivityAdvice;
import com.github.malibu_lib.pointcuts.OnBeforeSetContentViewActivityAdvice;
import com.github.malibu_lib.pointcuts.OnConfigurationChangedActivityAdvice;
import com.github.malibu_lib.pointcuts.OnCreateActivityAdvice;
import com.github.malibu_lib.pointcuts.OnCreateOptionsMenuActivityAdvice;
import com.github.malibu_lib.pointcuts.OnDestroyActivityAdvice;
import com.github.malibu_lib.pointcuts.OnOptionsItemSelectedActivityAdvice;
import com.github.malibu_lib.pointcuts.OnOptionsMenuClosedActivityAdvice;
import com.github.malibu_lib.pointcuts.OnPauseActivityAdvice;
import com.github.malibu_lib.pointcuts.OnPrepareOptionsMenuActivityAdvice;
import com.github.malibu_lib.pointcuts.OnRestartActivityAdvice;
import com.github.malibu_lib.pointcuts.OnRestoreInstanceStateActivityAdvice;
import com.github.malibu_lib.pointcuts.OnResumeActivityAdvice;
import com.github.malibu_lib.pointcuts.OnSaveInstanceStateActivityAdvice;
import com.github.malibu_lib.pointcuts.OnStartActivityAdvice;
import com.github.malibu_lib.pointcuts.OnStopActivityAdvice;

public class ActivityPointcutManager extends PointcutManager<AspectActivity> {

    public ActivityPointcutManager(AspectActivity pointcut) {
        super(pointcut);
    }

    // Activity state

    public void onCreate(Bundle savedInstanceState) {
        for (OnCreateActivityAdvice advice : advices(OnCreateActivityAdvice.class)) {
            advice.onCreate(pointcut, savedInstanceState);
        }
    }

    public void onStart() {
        for (OnStartActivityAdvice advice : advices(OnStartActivityAdvice.class)) {
            advice.onStart(pointcut);
        }
    }

    public void onRestart() {
        for (OnRestartActivityAdvice advice : advices(OnRestartActivityAdvice.class)) {
            advice.onRestart(pointcut);
        }
    }

    public void onResume() {
        for (OnResumeActivityAdvice advice : advices(OnResumeActivityAdvice.class)) {
            advice.onResume(pointcut);
        }
    }

    public void onPause() {
        for (OnPauseActivityAdvice advice : reverseAdvices(OnPauseActivityAdvice.class)) {
            advice.onPause(pointcut);
        }
    }

    public void onStop() {
        for (OnStopActivityAdvice advice : advices(OnStopActivityAdvice.class)) {
            advice.onStop(pointcut);
        }
    }

    public void onDestroy() {
        for (OnDestroyActivityAdvice advice : reverseAdvices(OnDestroyActivityAdvice.class)) {
            advice.onDestroy(pointcut);
        }

        clearAdvices();
    }

    // Activity state

    public void onSaveInstanceState(Bundle outState) {
        for (OnSaveInstanceStateActivityAdvice advice : advices(OnSaveInstanceStateActivityAdvice.class)) {
            advice.onSaveInstanceState(pointcut, outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (OnRestoreInstanceStateActivityAdvice advice : advices(OnRestoreInstanceStateActivityAdvice.class)) {
            advice.onRestoreInstanceState(pointcut, savedInstanceState);
        }
    }

    // Configuration change

    public void onConfigurationChanged(Configuration newConfig) {
        for (OnConfigurationChangedActivityAdvice advice : advices(OnConfigurationChangedActivityAdvice.class)) {
            advice.onConfigurationChanged(pointcut, newConfig);
        }
    }

    // Setting content view

    public void onBeforeSetContentView() {
        for (OnBeforeSetContentViewActivityAdvice advice : advices(OnBeforeSetContentViewActivityAdvice.class)) {
            advice.onBeforeSetContentView(pointcut);
        }
    }

    public void onAfterSetContentView() {
        for (OnAfterSetContentViewActivityAdvice advice : advices(OnAfterSetContentViewActivityAdvice.class)) {
            advice.onAfterSetContentView(pointcut);
        }
    }

    // Options menu

    public boolean onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean result = false;
        for (OnCreateOptionsMenuActivityAdvice advice : advices(OnCreateOptionsMenuActivityAdvice.class)) {
            result |= advice.onCreateOptionsMenu(pointcut, menu, menuInflater);
        }
        return result;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = false;
        for (OnPrepareOptionsMenuActivityAdvice advice : advices(OnPrepareOptionsMenuActivityAdvice.class)) {
            result |= advice.onPrepareOptionsMenu(pointcut, menu);
        }
        return result;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        for (OnOptionsItemSelectedActivityAdvice advice : advices(OnOptionsItemSelectedActivityAdvice.class)) {
            result |= advice.onOptionsItemSelected(pointcut, item);
        }
        return result;
    }

    public void onOptionsMenuClosed(Menu menu) {
        for (OnOptionsMenuClosedActivityAdvice advice : advices(OnOptionsMenuClosedActivityAdvice.class)) {
            advice.onOptionsMenuClosed(pointcut, menu);
        }
    }

    // Getting results from activity

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (OnActivityResultActivityAdvice advice : advices(OnActivityResultActivityAdvice.class)) {
            advice.onActivityResult(pointcut, requestCode, resultCode, data);
        }
    }

}
