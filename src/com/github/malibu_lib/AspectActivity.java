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

package com.github.malibu_lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.github.malibu_lib.internal.ActivityPointcutManager;

@SuppressLint("Registered")
public class AspectActivity extends Activity implements Pointcut {

    // Pointcut definition

    private final ActivityPointcutManager pointcutManager = new ActivityPointcutManager(this);

    @Override
    public void registerAdvice(Advice advice) {
        pointcutManager.registerAdvice(advice);
    }

    // Activity state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pointcutManager.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        pointcutManager.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        pointcutManager.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pointcutManager.onResume();
    }

    @Override
    protected void onPause() {
        pointcutManager.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        pointcutManager.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        pointcutManager.onDestroy();
        super.onDestroy();
    }

    // Activity state

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        pointcutManager.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pointcutManager.onRestoreInstanceState(savedInstanceState);
    }

    // Configuration change

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        pointcutManager.onConfigurationChanged(newConfig);
    }

    // Setting content view

    @Override
    public void setContentView(int layoutResID) {
        pointcutManager.onBeforeSetContentView();
        super.setContentView(layoutResID);
        pointcutManager.onAfterSetContentView();
    }

    @Override
    public void setContentView(View view) {
        pointcutManager.onBeforeSetContentView();
        super.setContentView(view);
        pointcutManager.onAfterSetContentView();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        pointcutManager.onBeforeSetContentView();
        super.setContentView(view, params);
        pointcutManager.onAfterSetContentView();
    }

    // Options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return pointcutManager.onCreateOptionsMenu(menu, getMenuInflater())
                || super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return pointcutManager.onPrepareOptionsMenu(menu) || super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return pointcutManager.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        pointcutManager.onOptionsMenuClosed(menu);
    }

    // Getting results from activity

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        pointcutManager.onActivityResult(requestCode, resultCode, data);
    }

    // Misc

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return pointcutManager.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return pointcutManager.onKeyUp(keyCode, event) || super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (!pointcutManager.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
