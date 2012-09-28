
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;
import android.content.Intent;

import com.github.malibu_lib.Advice;

public interface OnTaskRemovedServiceAdvice extends Advice {

    public void onTaskRemoved(Service service, Intent rootIntent);

}
