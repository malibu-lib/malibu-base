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

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.malibu_lib.pointcuts.fragmentactivity.OnActivityResultFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnAfterSetContentViewFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnBackPressedFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnBeforeSetContentViewFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnConfigurationChangedFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnCreateFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnCreateOptionsMenuFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnDestroyFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnKeyDownFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnKeyUpFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnOptionsItemSelectedFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnOptionsMenuClosedFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnPauseFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnPrepareOptionsMenuFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnRestartFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnRestoreInstanceStateFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnResumeFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnSaveInstanceStateFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnStartFragmentActivityAdvice;
import com.github.malibu_lib.pointcuts.fragmentactivity.OnStopFragmentActivityAdvice;

public class FragmentActivityPointcutManager extends PointcutManager<FragmentActivity> {

    public FragmentActivityPointcutManager(FragmentActivity pointcut) {
        super(pointcut);
    }

    // Activity state

    public void onCreate(Bundle savedInstanceState) {
        for (OnCreateFragmentActivityAdvice advice : advices(OnCreateFragmentActivityAdvice.class)) {
            advice.onCreate(pointcut, savedInstanceState);
        }
    }

    public void onStart() {
        for (OnStartFragmentActivityAdvice advice : advices(OnStartFragmentActivityAdvice.class)) {
            advice.onStart(pointcut);
        }
    }

    public void onRestart() {
        for (OnRestartFragmentActivityAdvice advice : advices(OnRestartFragmentActivityAdvice.class)) {
            advice.onRestart(pointcut);
        }
    }

    public void onResume() {
        for (OnResumeFragmentActivityAdvice advice : advices(OnResumeFragmentActivityAdvice.class)) {
            advice.onResume(pointcut);
        }
    }

    public void onPause() {
        for (OnPauseFragmentActivityAdvice advice : reverseAdvices(OnPauseFragmentActivityAdvice.class)) {
            advice.onPause(pointcut);
        }
    }

    public void onStop() {
        for (OnStopFragmentActivityAdvice advice : reverseAdvices(OnStopFragmentActivityAdvice.class)) {
            advice.onStop(pointcut);
        }
    }

    public void onDestroy() {
        for (OnDestroyFragmentActivityAdvice advice : reverseAdvices(OnDestroyFragmentActivityAdvice.class)) {
            advice.onDestroy(pointcut);
        }
    }

    // Activity state

    public void onSaveInstanceState(Bundle outState) {
        for (OnSaveInstanceStateFragmentActivityAdvice advice : advices(OnSaveInstanceStateFragmentActivityAdvice.class)) {
            advice.onSaveInstanceState(pointcut, outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (OnRestoreInstanceStateFragmentActivityAdvice advice : advices(OnRestoreInstanceStateFragmentActivityAdvice.class)) {
            advice.onRestoreInstanceState(pointcut, savedInstanceState);
        }
    }

    // Configuration change

    public void onConfigurationChanged(Configuration newConfig) {
        for (OnConfigurationChangedFragmentActivityAdvice advice : advices(OnConfigurationChangedFragmentActivityAdvice.class)) {
            advice.onConfigurationChanged(pointcut, newConfig);
        }
    }

    // Setting content view

    public void onBeforeSetContentView() {
        for (OnBeforeSetContentViewFragmentActivityAdvice advice : advices(OnBeforeSetContentViewFragmentActivityAdvice.class)) {
            advice.onBeforeSetContentView(pointcut);
        }
    }

    public void onAfterSetContentView() {
        for (OnAfterSetContentViewFragmentActivityAdvice advice : advices(OnAfterSetContentViewFragmentActivityAdvice.class)) {
            advice.onAfterSetContentView(pointcut);
        }
    }

    // Options menu

    public boolean onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean result = false;
        for (OnCreateOptionsMenuFragmentActivityAdvice advice : advices(OnCreateOptionsMenuFragmentActivityAdvice.class)) {
            result |= advice.onCreateOptionsMenu(pointcut, menu, menuInflater);
        }
        return result;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = false;
        for (OnPrepareOptionsMenuFragmentActivityAdvice advice : advices(OnPrepareOptionsMenuFragmentActivityAdvice.class)) {
            result |= advice.onPrepareOptionsMenu(pointcut, menu);
        }
        return result;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        for (OnOptionsItemSelectedFragmentActivityAdvice advice : advices(OnOptionsItemSelectedFragmentActivityAdvice.class)) {
            result |= advice.onOptionsItemSelected(pointcut, item);
        }
        return result;
    }

    public void onOptionsMenuClosed(Menu menu) {
        for (OnOptionsMenuClosedFragmentActivityAdvice advice : advices(OnOptionsMenuClosedFragmentActivityAdvice.class)) {
            advice.onOptionsMenuClosed(pointcut, menu);
        }
    }

    // Getting results from activity

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (OnActivityResultFragmentActivityAdvice advice : advices(OnActivityResultFragmentActivityAdvice.class)) {
            advice.onActivityResult(pointcut, requestCode, resultCode, data);
        }
    }

    // Misc

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean result = false;
        for (OnKeyDownFragmentActivityAdvice advice : advices(OnKeyDownFragmentActivityAdvice.class)) {
            result |= advice.onKeyDown(pointcut, keyCode, event);
        }
        return result;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean result = false;
        for (OnKeyUpFragmentActivityAdvice advice : advices(OnKeyUpFragmentActivityAdvice.class)) {
            result |= advice.onKeyUp(pointcut, keyCode, event);
        }
        return result;
    }

    public boolean onBackPressed() {
        boolean result = false;
        for (OnBackPressedFragmentActivityAdvice advice : advices(OnBackPressedFragmentActivityAdvice.class)) {
            result |= advice.onBackPressed(pointcut);
        }
        return result;
    }

}
