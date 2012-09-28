
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;
import android.content.Intent;

import com.github.malibu_lib.Advice;

public interface OnStartCommandServiceAdvice extends Advice {

    public void onStartCommand(Service service, Intent intent, int flags, int startId);

}
