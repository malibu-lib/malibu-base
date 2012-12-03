
package com.github.malibu_lib.pointcuts.activity;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

import com.github.malibu_lib.Advice;

public interface OnCreateContextMenuActivityAdvice extends Advice {

    public void onCreateContextMenu(Activity activity, ContextMenu menu, View v,
            ContextMenuInfo menuInfo);

}
