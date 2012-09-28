
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.github.malibu_lib.Advice;

public interface OnBindServiceAdvice extends Advice {

    public IBinder onBind(Service service, Intent intent);

}
