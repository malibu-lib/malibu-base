
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;

import com.github.malibu_lib.Advice;

public interface OnCreateServiceAdvice extends Advice {

    public void onCreate(Service service);

}
