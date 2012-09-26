/*******************************************************************************
 * Copyright (c) 2012 MASConsult Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.malibu_lib.internal;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.malibu_lib.pointcuts.activity.OnActivityResultActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnAfterSetContentViewActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnBeforeSetContentViewActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnConfigurationChangedActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnCreateActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnCreateOptionsMenuActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnDestroyActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnOptionsItemSelectedActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnOptionsMenuClosedActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnPauseActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnPrepareOptionsMenuActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnRestartActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnRestoreInstanceStateActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnResumeActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnSaveInstanceStateActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnStartActivityAdvice;
import com.github.malibu_lib.pointcuts.activity.OnStopActivityAdvice;

public class ActivityPointcutManager extends PointcutManager<Activity> {

    public ActivityPointcutManager(Activity pointcut) {
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
        for (OnStopActivityAdvice advice : reverseAdvices(OnStopActivityAdvice.class)) {
            advice.onStop(pointcut);
        }
    }

    public void onDestroy() {
        for (OnDestroyActivityAdvice advice : reverseAdvices(OnDestroyActivityAdvice.class)) {
            advice.onDestroy(pointcut);
        }
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
