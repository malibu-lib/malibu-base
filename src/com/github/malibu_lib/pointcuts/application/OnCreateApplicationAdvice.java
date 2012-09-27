
package com.github.malibu_lib.pointcuts.application;

import android.app.Application;

import com.github.malibu_lib.Advice;

public interface OnCreateApplicationAdvice extends Advice {

    public void onCreate(Application application);

}
