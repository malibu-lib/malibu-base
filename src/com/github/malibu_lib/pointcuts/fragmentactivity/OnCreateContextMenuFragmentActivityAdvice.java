
package com.github.malibu_lib.pointcuts.fragmentactivity;

import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

import com.github.malibu_lib.Advice;

public interface OnCreateContextMenuFragmentActivityAdvice extends Advice {

    public void onCreateContextMenu(FragmentActivity activity, ContextMenu menu, View v,
            ContextMenuInfo menuInfo);

}
